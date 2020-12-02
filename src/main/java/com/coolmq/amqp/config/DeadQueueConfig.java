//package com.coolmq.amqp.config;
//
//import com.coolmq.amqp.util.MQConstants;
//import com.coolmq.amqp.util.TransMessageListener;
//import org.springframework.amqp.core.*;
//import org.springframework.amqp.rabbit.connection.ConnectionFactory;
//import org.springframework.amqp.rabbit.listener.SimpleMessageListenerContainer;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//
//import java.util.HashMap;
//import java.util.Map;
//
//
///**
// * <p><b>Description:</b> RabbitMQ交换机、队列的配置类.定义交换机、key、queue并做好绑定。
// * 同时定义每个队列的ttl，队列最大长度，Qos等等
// * 这里只绑定了死信队列。建议每个队列定义自己的QueueConfig
// * <p><b>Company:</b>
// *
// * @author created by fw at 21:54 on 2017-12-23
// * @version V0.1
// */
//@Configuration
//public class DeadQueueConfig {
//
//
//    //业务队列消费失败的消息会进入死信队列
//
//    //-------------------------------------死信队列部分-----------------------
//    /**
//     * 死信交换机
//     */
//    @Bean
//    public TopicExchange dlxExchange() {
//        return new TopicExchange(MQConstants.DLX_EXCHANGE);
//    }
//
//
//    /**
//     * 死信队列
//     */
//    @Bean
//    public Queue dlxQueue() {
//        return new Queue(MQConstants.DLX_QUEUE,true,false,false,null);
//    }
//    /**
//     * 通过死信路由key绑定死信交换机和死信队列
//     */
//    @Bean
//    public Binding dlxBinding() {
//        return BindingBuilder.bind(dlxQueue()).to(dlxExchange())
//                .with(MQConstants.DLX_ROUTING_KEY);
//    }
//
//    //--------------------------业务队列部分---------------------------------
//
//    /**
//     * 业务交换机
//     * @return
//     */
//    @Bean
//    public TopicExchange busExchange() {
//        return new TopicExchange(MQConstants.BUSINESS_EXCHANGE);
//    }
//
//
//    /**
//     * 业务队列
//     * @return
//     */
//    @Bean
//    public Queue busQueue() {
//        Map<String,Object> map=new HashMap<>();
//        map.put("x-dead-letter-exchange",MQConstants.DLX_EXCHANGE);
//        //        map.put("x-dead-letter-routing-key",MQConstants.DLX_ROUTING_KEY);
//        return new Queue(MQConstants.BUSINESS_QUEUE,true,false,false,map);
//    }
//
//    @Bean
//    public Binding busBinding() {
//        return BindingBuilder.bind(busQueue()).to(busExchange())
//                .with(MQConstants.BUSINESS_KEY);
//    }
//
//    /**
//     * 死信队列的监听
//     * @param connectionFactory RabbitMQ连接工厂
//     * @param transMessageListener  队列监听器
//     * @return 监听容器对象
//     */
//    @Bean
//    public SimpleMessageListenerContainer simpleMessageListenerContainer(ConnectionFactory connectionFactory,
//                                                                         TransMessageListener transMessageListener) {
//
//        SimpleMessageListenerContainer container = new SimpleMessageListenerContainer(connectionFactory);
//        container.setQueues(busQueue());
//        container.setExposeListenerChannel(true);
//        container.setAcknowledgeMode(AcknowledgeMode.MANUAL);
//        container.setMessageListener(transMessageListener);
//        return container;
//    }
//
//}
