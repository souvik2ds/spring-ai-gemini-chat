package com.souvik.spring_ai.Service;

import org.springframework.ai.chat.client.ChatClient;
import org.springframework.ai.chat.client.advisor.MessageChatMemoryAdvisor;
import org.springframework.ai.chat.memory.ChatMemory;
import org.springframework.ai.chat.memory.MessageWindowChatMemory;
import org.springframework.stereotype.Service;

@Service
public class ChatService {
    private final ChatClient client;
    public ChatService(ChatClient.Builder client)
    {
        this.client = client
                .defaultAdvisors(
                        MessageChatMemoryAdvisor.builder(
                                MessageWindowChatMemory.builder().build()
                        ).build()
                )
                .build();

    }
    public String reply(String msg,String conversationId)
    {
        return client
                .prompt()
                .user(msg)
                .advisors(a -> a.param(ChatMemory.CONVERSATION_ID,conversationId))
                .call()
                .content();
        //in place of content() i can use chatResponse()
        //                .getResult()
        //                .getOutput()
        //                .getText(); also.
    }

}
