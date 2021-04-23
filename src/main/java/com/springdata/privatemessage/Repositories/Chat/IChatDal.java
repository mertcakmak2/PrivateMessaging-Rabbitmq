package com.springdata.privatemessage.Repositories.Chat;

import com.springdata.privatemessage.Entities.Chat;

import java.util.List;

public interface IChatDal {
    List<Chat> getChats();

    List<Chat> getUserChats(int userId);

    Chat saveChat(Chat chat);

    Chat deleteChat(Chat chat);
}
