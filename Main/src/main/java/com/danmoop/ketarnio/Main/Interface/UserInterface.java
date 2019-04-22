package com.danmoop.ketarnio.Main.Interface;

import com.danmoop.ketarnio.Main.model.UserModel;

import java.util.List;

public interface UserInterface
{
    void save(UserModel userModel);
    UserModel findByUsername(String username);
    UserModel findByEmail(String email);

    List<UserModel> findAll();
}