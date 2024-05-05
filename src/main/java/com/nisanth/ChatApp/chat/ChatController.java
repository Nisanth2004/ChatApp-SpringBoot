package com.nisanth.ChatApp.chat;

import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessageHeaderAccessor;
import org.springframework.stereotype.Controller;

@Controller
public class ChatController
{
    @MessageMapping("/chat.sendMessage")
    @SendTo("/topic/public")
    //Messagemapping - what is the url we used to use this invoke this method
   public ChatMessage sendMessage(@Payload ChatMessage chatMessage)
   {
       return chatMessage;

   }
    @MessageMapping("/chat.addUser")
    @SendTo("/topic/public")
   public ChatMessage addUser(@Payload ChatMessage chatMessage,
                              SimpMessageHeaderAccessor headerAccessor)
   {
       // Add username in web socket session
      headerAccessor.getSessionAttributes().put("username",chatMessage.getSender());
      return chatMessage;
   }
}
