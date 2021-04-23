package com.springdata.privatemessage.Controllers;

import com.springdata.privatemessage.Entities.Chat;
import com.springdata.privatemessage.Services.Chat.IChatService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/chat")
@RequiredArgsConstructor
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class ChatController {

    private final IChatService chatService;

    @GetMapping(value = "/test")
    public String getTest(){
        return "chat test";
    }

    @GetMapping(value = "")
    public List<Chat> getAllChats(){
        return chatService.getChats();
    }

    @GetMapping(value = "/{userId}")
    public List<Chat> getChatByUserId(@PathVariable int userId){
        return chatService.
                getUserChats(userId);
    }

    @PostMapping(value = "")
    public Chat saveChat(@RequestBody Chat chat){
        return chatService.saveChat(chat);
    }

    @DeleteMapping(value = "")
    public Chat deleteChat(@RequestBody Chat chat){
        return chatService.deleteChat(chat);
    }

}
