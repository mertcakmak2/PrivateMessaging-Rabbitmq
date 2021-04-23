package com.springdata.privatemessage.Services.User;

import com.springdata.privatemessage.Dtos.UserDtos.LoginDto;
import com.springdata.privatemessage.Entities.User;

import java.util.List;

public interface IUserService {

    List<User> getUsers();

    User saveUser(User user);

    User updateUser(User user);

    User login(LoginDto loginDto) throws Exception;

}