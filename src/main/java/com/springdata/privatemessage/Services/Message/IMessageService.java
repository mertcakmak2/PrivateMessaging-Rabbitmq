package com.springdata.privatemessage.Services.Message;

import com.springdata.privatemessage.Entities.Message;

import java.util.List;

public interface IMessageService {

    List<Message> getMessages();

    Message saveMessage(Message message);

    Message deleteMessage(Message message);

    List<Message> getPrivateMessages(int ChatId);

}