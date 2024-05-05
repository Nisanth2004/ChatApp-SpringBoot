package com.nisanth.ChatApp.chat;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class ChatMessage {
    private String content;
    private String sender;
    private  MessageType type;
}

