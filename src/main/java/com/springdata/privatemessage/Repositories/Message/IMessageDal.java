package com.springdata.privatemessage.Repositories.Message;

import com.springdata.privatemessage.Entities.Message;

import java.util.List;

public interface IMessageDal {

    List<Message> getMessages();

    Message saveMessage(Message message);

    Message deleteMessage(Message message);

    List<Message> getPrivateMessages(int chatId);

}
