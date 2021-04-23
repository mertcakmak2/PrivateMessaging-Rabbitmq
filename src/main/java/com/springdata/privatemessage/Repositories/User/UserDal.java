package com.springdata.privatemessage.Repositories.User;

import com.springdata.privatemessage.Entities.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class UserDal implements IUserDal {

    private final IUserRepository repository;

    @Override
    public List<User> getUsers() {
        return repository.findAll();
    }

    @Override
    public User getUser(String email) {
        return repository.findByEmail(email);
    }

    @Override
    public User saveUser(User user) {
        return repository.save(user);
    }

    @Override
    public User updateUser(User user) {
        return null;
    }

}
