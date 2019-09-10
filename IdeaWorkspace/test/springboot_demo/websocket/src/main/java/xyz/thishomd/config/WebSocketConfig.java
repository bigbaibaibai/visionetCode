package xyz.thishomd.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker;
import org.springframework.web.socket.config.annotation.StompEndpointRegistry;
import org.springframework.web.socket.config.annotation.WebSocketMessageBrokerConfigurer;

@Configuration
@EnableWebSocketMessageBroker
public class WebSocketConfig implements WebSocketMessageBrokerConfigurer {

    // 注册一个节点
    @Override
    public void registerStompEndpoints(StompEndpointRegistry registry) {
        registry.addEndpoint("/socket").withSockJS();
    }

    //注册指定前缀的连接
    @Override
    public void configureMessageBroker(MessageBrokerRegistry registry) {
        //此前缀的连接都可建立Websocket连接
        registry.enableSimpleBroker("/server", "/user");
    }
}
