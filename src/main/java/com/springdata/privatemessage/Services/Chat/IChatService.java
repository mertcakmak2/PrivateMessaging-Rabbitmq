package com.springdata.privatemessage.Services.Chat;

import com.springdata.privatemessage.Entities.Chat;

import java.util.List;

public interface IChatService {

    List<Chat> getChats();

    List<Chat> getUserChats(int userId);

    Chat saveChat(Chat chat);

    Chat deleteChat(Chat chat);
}
