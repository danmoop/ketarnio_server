package com.danmoop.ketarnio.Main.Service;

import com.danmoop.ketarnio.Main.model.UserModel;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface UserService extends MongoRepository<UserModel, String>
{
    UserModel findByUsername(String username);
    UserModel findByEmail(String email);

    List<UserModel> findAll();
}