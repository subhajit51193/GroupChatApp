package com.chat.app.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker;
import org.springframework.web.socket.config.annotation.StompEndpointRegistry;
import org.springframework.web.socket.config.annotation.WebSocketMessageBrokerConfigurer;

@Configuration
@EnableWebSocketMessageBroker
public class Config implements WebSocketMessageBrokerConfigurer{

	/**
	 * This method registers a STOMP endPoint for WebSocket communication.
	 * In this case, it registers an endPoint named "/server1".
	 * 
	 * @param: StompEndpointRegistry -> A contract for registering STOMP 
	 * over WebSocket endPoints.
	 */
	@Override
	public void registerStompEndpoints(StompEndpointRegistry registry) {
		
		registry.addEndpoint("/server1").withSockJS();
	}
	
	/**
	 * This method configures the message broker used in the application. 
	 * In this case, it enables a simple in-memory message broker for handling 
	 * message communication between clients and the server. Messages sent to 
	 * destinations prefixed with "/topic" will be routed to the broker, allowing 
	 * for pub-sub messaging. The setApplicationDestinationPrefixes("/app") method 
	 * defines a prefix to be used when mapping application destinations.
	 * 
	 * @param: MessageBrokerRegistry -> A registry for configuring message broker options.
	 */
	@Override
	public void configureMessageBroker(MessageBrokerRegistry registry) {
		
		registry.enableSimpleBroker("/topic");
		registry.setApplicationDestinationPrefixes("/app");
	}
	
}
