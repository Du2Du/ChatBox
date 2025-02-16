package com.du2du.chat_box.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker;
import org.springframework.web.socket.config.annotation.StompEndpointRegistry;
import org.springframework.web.socket.config.annotation.WebSocketMessageBrokerConfigurer;

@Configuration
@EnableWebSocketMessageBroker
public class WebsocketConfiguration implements WebSocketMessageBrokerConfigurer {

  @Override
  public void registerStompEndpoints(StompEndpointRegistry registry) {
    WebSocketMessageBrokerConfigurer.super.registerStompEndpoints(registry);
  }

  @Override
  public void configureMessageBroker(MessageBrokerRegistry registry) {
    WebSocketMessageBrokerConfigurer.super.configureMessageBroker(registry);
  }
}
