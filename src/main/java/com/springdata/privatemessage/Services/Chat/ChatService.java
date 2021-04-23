package com.springdata.privatemessage.Services.Chat;

import com.springdata.privatemessage.Entities.Chat;
import com.springdata.privatemessage.Repositories.Chat.IChatDal;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ChatService implements IChatService {

    private final IChatDal chatDal;

    @Override
    public List<Chat> getChats() {
        return chatDal.getChats();
    }

    @Override
    public List<Chat> getUserChats(int userId) {
        return chatDal.getUserChats(userId);
    }

    @Override
    public Chat saveChat(Chat chat) {
        return chatDal.saveChat(chat);
    }

    @Override
    public Chat deleteChat(Chat chat) {
        return chatDal.deleteChat(chat);
    }
}
