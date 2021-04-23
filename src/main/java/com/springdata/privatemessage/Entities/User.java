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
@Table(name = "User")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int userId;
    private String fullName;
    private String email;
    private String password;
    private String imagePath;
    @OneToMany(mappedBy = "sender", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JsonBackReference(value = "sender_chat")
    private List<Chat> senderChat;
    @OneToMany(mappedBy = "recipiement", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JsonBackReference(value = "recipiement_chat")
    private List<Chat> recipiementChat;
}
