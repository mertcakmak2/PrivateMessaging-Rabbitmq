package com.springdata.privatemessage.Services.User;

import com.springdata.privatemessage.Dtos.UserDtos.LoginDto;
import com.springdata.privatemessage.Entities.User;
import com.springdata.privatemessage.Repositories.User.IUserDal;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService implements IUserService{

    private final IUserDal userDal;

    @Override
    public List<User> getUsers() {
        return userDal.getUsers();
    }

    @Override
    public User saveUser(User user) {
        return userDal.saveUser(user);
    }

    @Override
    public User updateUser(User user) {
        return userDal.updateUser(user);
    }

    @Override
    public User login(LoginDto loginDto) throws Exception {
        User user = userDal.getUser(loginDto.getEmail());
        if(loginDto.getPassword().equals(user.getPassword())){
            return user;
        }
        throw new NullPointerException();
    }
}
