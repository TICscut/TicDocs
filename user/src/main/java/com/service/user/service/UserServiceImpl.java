package com.service.user.service;

import com.service.user.entity.User;
import com.service.user.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.security.crypto.password.PasswordEncoder;
import com.service.user.util.JwtUtil;
import com.service.user.enums.MessageEnum;

@Service
public class UserServiceImpl implements UserService {

    private final UserMapper userMapper;
    private final PasswordEncoder passwordEncoder;
    private final JwtUtil jwtUtil;

    @Autowired
    public UserServiceImpl(UserMapper userMapper, JwtUtil jwtUtil, PasswordEncoder passwordEncoder) {
        this.userMapper = userMapper;
        this.jwtUtil = jwtUtil;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public User register(String username, String password) throws Exception {
        // 输入长度是否合法
        if (!username.matches("^.{1,20}$") || !password.matches("^.{10,20}$")) {
            throw new IllegalArgumentException(MessageEnum.REGISTER_FAIL_INVALID_INPUT.getMessage());
        }

        // 判断是否已经存在用户
        if (userMapper.selectByUsername(username) != null) {
            throw new Exception(MessageEnum.REGISTER_FAIL_USERNAME_EXISTS.getMessage());
        }

        // 不存在用户，进行哈希后插入
        String hashedPassword = passwordEncoder.encode(password);
        User user = new User(username, hashedPassword);

        // 数据库插入操作，可能发生异常
        try {
            if (userMapper.insertUser(user)) {
                return user;
            }
        } catch (Exception e) {
            throw  new Exception(MessageEnum.REGISTER_FAIL_INTERNAL_ERR.getMessage());
        }

        // 不会到达，应对编译检查
        return null;
    }

    @Override
    public User login(String username, String password) throws Exception {

        // 查找是否有对应用户
        User user = userMapper.selectByUsername(username);
        if (user == null) {
            throw new Exception(MessageEnum.LOGIN_FAIL_NOT_EXIST.getMessage());
        }

        // 对密码hash后进行比较
        if (!passwordEncoder.matches(password, user.getHashedPasswd())) {
            throw new Exception(MessageEnum.LOGIN_FAIL_WRONG_PASSWORD.getMessage());
        }

        // 存在对应用户
        return user;
    }

    @Override
    public String[] refreshUserToken(String refreshToken) throws Exception {

        // 是否有效
        if (!jwtUtil.validateToken(refreshToken)) {
            throw new Exception(MessageEnum.TOKEN_REFRESH_FAIL_EXPIRED.getMessage());
        }

        // 查找用户
        String username = jwtUtil.extractUsername(refreshToken);
        User user = userMapper.selectByUsername(username);
        
        if (user == null) {
            throw new Exception(MessageEnum.TOKEN_REFRESH_FAIL_USER_NOT_EXIST.getMessage());
        }

        String newAccessToken = jwtUtil.generateAccessToken(username);
        String newRefreshToken = jwtUtil.generateRefreshToken(username);

        return new String[]{newAccessToken, newRefreshToken};
    }
}
