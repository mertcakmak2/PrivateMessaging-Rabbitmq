package com.springdata.privatemessage.Services.Message;

import com.springdata.privatemessage.Entities.Message;
import com.springdata.privatemessage.Repositories.Message.IMessageDal;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MessageService implements IMessageService {

    private final IMessageDal messageDal;

    @Override
    public List<Message> getMessages() {
        return messageDal.getMessages();
    }

    @Override
    public Message saveMessage(Message message) {
        String senderId = String.valueOf(message.getSenderId());
        String recipiementId = String.valueOf(message.getRecipientId());
        int chatId = 0;
        if(message.getSenderId() < message.getRecipientId()){
            chatId = Integer.parseInt(senderId+recipiementId);
        } else {
            chatId = Integer.parseInt(recipiementId+senderId);
        }
        message.setChatId(chatId);
        return messageDal.saveMessage(message);
    }

    @Override
    public Message deleteMessage(Message message) {
        return messageDal.deleteMessage(message);
    }

    @Override
    public List<Message> getPrivateMessages(int chatId) {
        return messageDal.getPrivateMessages(chatId);
    }
}