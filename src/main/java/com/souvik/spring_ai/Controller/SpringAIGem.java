package com.souvik.spring_ai.Controller;

import com.souvik.spring_ai.Service.ChatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SpringAIGem {
    private final ChatService service;

    public SpringAIGem(ChatService service) {
        this.service = service;
    }
    @GetMapping("hi")
    public String ss()
    {
        return "Souvik";
    }
    @GetMapping("/ask")
    public ResponseEntity<String> prove(@RequestParam String msg,@RequestParam String sessionId)
    {
       String res=service.reply(msg,sessionId);
      return ResponseEntity.ok(res);
    }

}
