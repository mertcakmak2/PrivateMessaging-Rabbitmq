package com.springdata.privatemessage.Entities;


import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.*;

import javax.persistence.*;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
@Table(name = "Message")
public class Message {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private int senderId;
    private int recipientId;
    private String content;
    private String msst;
    private int chatId;
    @OneToMany(mappedBy = "lastMessage", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JsonBackReference(value = "chat")
    private List<Chat> chat;
}
