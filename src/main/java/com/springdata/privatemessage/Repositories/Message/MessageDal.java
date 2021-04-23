package com.springdata.privatemessage.Repositories.Message;


import com.springdata.privatemessage.Config.RabbitMqConfig;
import com.springdata.privatemessage.Entities.Message;
import lombok.RequiredArgsConstructor;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class MessageDal implements IMessageDal {

    private final IMessageRepository repository;
    private final RabbitTemplate rabbitTemplate;

    @Override
    public List<Message> getMessages() {
        return repository.findAll();
    }

    @Override
    public Message saveMessage(Message message) {
        Message savedMessage =  repository.save(message);
        if(savedMessage.getId() > 0){
            rabbitTemplate.convertAndSend(RabbitMqConfig.EXCHANGE, RabbitMqConfig.ROUTİNG_KEY, savedMessage);
        }
        return savedMessage;
    }

    @Override
    public Message deleteMessage(Message message) {
        repository.delete(message);
        return message;
    }

    @Override
    public List<Message> getPrivateMessages(int chatId) {
        return repository.findByChatIdOrderByIdAsc(chatId);
    }
}