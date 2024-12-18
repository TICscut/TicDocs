package com.service.user.config;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * RabbitMQ配置类
 */
@Configuration
public class RabbitConfig {

    /**
     * 创建RabbitTemplate bean，用于发送消息
     *
     * @param connectionFactory 连接工厂
     * @return 配置好的RabbitTemplate实例
     */
    @Bean
    public RabbitTemplate rabbitTemplate(ConnectionFactory connectionFactory){
        RabbitTemplate rabbitTemplate = new RabbitTemplate(connectionFactory);
        rabbitTemplate.setMessageConverter(jsonMessageConverter());
        return rabbitTemplate;
    }

    /**
     * 配置消息转换器，用于将Java对象转换为JSON格式的消息
     *
     * @return 配置好的MessageConverter实例
     */
    @Bean
    public MessageConverter jsonMessageConverter(){
        return new Jackson2JsonMessageConverter();
    }

    /**
     * 创建并配置一个Direct类型的交换机
     *
     * @return 配置好的DirectExchange实例
     */
    @Bean
    public DirectExchange teamExchange() {
        return new DirectExchange("com.team");
    }

    /**
     * 创建一个队列
     *
     * @return 配置好的Queue实例
     */
    @Bean
    public Queue registerQueue() {
        return new Queue("com.team.register", true); // 第二个参数表示队列是否持久化
    }

    /**
     * 将register队列绑定到team交换机，并指定路由键
     *
     * @param registerQueue 要绑定的队列
     * @param teamExchange 交换机
     * @return 配置好的Binding实例
     */
    @Bean
    public Binding registerBinding(Queue registerQueue, DirectExchange teamExchange) {
        return BindingBuilder.bind(registerQueue).to(teamExchange).with("com.team.register");
    }
}