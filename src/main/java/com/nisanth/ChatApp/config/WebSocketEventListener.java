package com.nisanth.ChatApp.config;

import com.nisanth.ChatApp.chat.ChatMessage;
import com.nisanth.ChatApp.chat.MessageType;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.event.EventListener;
import org.springframework.messaging.simp.SimpMessageSendingOperations;
import org.springframework.messaging.simp.stomp.StompHeaderAccessor;
import org.springframework.stereotype.Component;
import org.springframework.web.socket.messaging.SessionDisconnectEvent;

@Component
@RequiredArgsConstructor
@Slf4j
public class WebSocketEventListener
{
    private final SimpMessageSendingOperations messageTemplate;
    @EventListener
    public void handleWebSocketDisconnectListener(SessionDisconnectEvent event)
    {
        StompHeaderAccessor headerAccessor=StompHeaderAccessor.wrap(event.getMessage());
        String username=(String) headerAccessor.getSessionAttributes().get("username");
        if(username!=null)
        {
            log.info("User Disconnected: {}",username);
            var chatMessage= ChatMessage.builder()
                    .type(MessageType.LEAVE)
                    .sender(username)
                    .build();
            // send the message to common endpoint which all can seen
            messageTemplate.convertAndSend("/topic/public",chatMessage);
        }

    }
}
