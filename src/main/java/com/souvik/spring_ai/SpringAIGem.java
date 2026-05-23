package com.souvik.spring_ai;

import org.springframework.ai.chat.model.ChatResponse;
import org.springframework.ai.chat.prompt.Prompt;
import org.springframework.ai.google.genai.GoogleGenAiChatModel;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SpringAIGem {
    private final GoogleGenAiChatModel chatmodel;
    public SpringAIGem(GoogleGenAiChatModel chatmodel)
    {
        this.chatmodel=chatmodel;
    }
    @GetMapping("hi")
    public String ss()
    {
        return "Souvik";
    }
    @GetMapping("ask/{msg}")
    public ResponseEntity<String> prove(@PathVariable String msg)
    {
       //String res=chatmodel.call(msg);
        Prompt prompt = new Prompt(msg);

        ChatResponse response = chatmodel.call(prompt);

        String res = response.getResult()
                .getOutput()
                .getText();
      return ResponseEntity.ok(res);
    }

}
