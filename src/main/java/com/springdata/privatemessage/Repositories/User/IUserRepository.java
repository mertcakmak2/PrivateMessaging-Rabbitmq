package com.springdata.privatemessage.Repositories.User;

import com.springdata.privatemessage.Entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IUserRepository extends JpaRepository <User, Integer> {

    User findByEmail(String email);
}
