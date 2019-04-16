package com.danmoop.ketarnio.Main.Service;

import com.danmoop.ketarnio.Main.model.User;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface UserService extends MongoRepository<User, String>
{
    User findByUsername(String username);
    User findByEmail(String email);

    List<User> findAll();
}