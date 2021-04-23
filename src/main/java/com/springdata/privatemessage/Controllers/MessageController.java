package com.springdata.privatemessage.Controllers;

import com.springdata.privatemessage.Entities.Message;
import com.springdata.privatemessage.Services.Message.IMessageService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/message")
@RequiredArgsConstructor
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class MessageController {

    private final IMessageService messageService;

    @PostMapping(value = "")
    public Message onMessage(@RequestBody Message message){
        return messageService.saveMessage(message);
    }

    @GetMapping(value = "")
    public List<Message> getMessages(){
        return messageService.getMessages();
    }

    @GetMapping(value = "/{chatId}")
    public List<Message> getPrivateMessages(@PathVariable int chatId){
        return messageService.getPrivateMessages(chatId);
    }
}
