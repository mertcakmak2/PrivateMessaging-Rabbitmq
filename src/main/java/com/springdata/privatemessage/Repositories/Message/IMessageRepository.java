package com.springdata.privatemessage.Repositories.Message;


import com.springdata.privatemessage.Entities.Message;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IMessageRepository extends JpaRepository<Message, Long>, PagingAndSortingRepository<Message, Long> {

    List<Message> findByChatIdOrderByIdAsc(int chatId);
}
