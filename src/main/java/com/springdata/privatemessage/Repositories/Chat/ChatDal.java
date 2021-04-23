package com.springdata.privatemessage.Repositories.Chat;

import com.springdata.privatemessage.Entities.Chat;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class ChatDal implements IChatDal{

    private final IChatRepository repository;

    @Override
    public List<Chat> getChats() {
        return repository.findAll();
    }

    @Override
    public List<Chat> getUserChats(int userId) {
        List<Chat> chats = repository.findByRecipiement_UserIdOrSender_UserId(userId, userId);
        return chats;
    }

    @Override
    public Chat saveChat(Chat chat) {
        return repository.save(chat);
    }

    @Override
    public Chat deleteChat(Chat chat) {
        repository.delete(chat);
        return chat;
    }
}
