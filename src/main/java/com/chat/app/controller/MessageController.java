package com.chat.app.controller;

import java.time.LocalDateTime;

import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.chat.app.entity.Message;

@RestController
@RequestMapping
public class MessageController {

	@MessageMapping("/message")
	@SendTo("/topic/return-to")
	public Message getContent(@RequestBody Message message) {
		
		message.setDate(LocalDateTime.now());
		try {
			
			Thread.sleep(2000);
			
		} catch (InterruptedException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return message;
	}
}
