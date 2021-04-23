package com.springdata.privatemessage.Repositories.User;

import com.springdata.privatemessage.Entities.User;

import java.util.List;

public interface IUserDal {
    List<User> getUsers();

    User getUser(String email);

    User saveUser(User user);

    User updateUser(User user);

}
