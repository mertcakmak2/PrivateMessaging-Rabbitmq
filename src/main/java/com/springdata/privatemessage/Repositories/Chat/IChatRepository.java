package com.springdata.privatemessage.Repositories.Chat;

import com.springdata.privatemessage.Entities.Chat;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IChatRepository extends JpaRepository<Chat, Integer> {

    List<Chat> findByRecipiement_UserIdOrSender_UserId(int recipiementId, int senderId);
}
