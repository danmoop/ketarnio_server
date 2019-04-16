package com.danmoop.ketarnio.Main.Interface;

import com.danmoop.ketarnio.Main.model.User;

import java.util.List;

public interface UserInterface
{
    void save(User user);
    User findByUsername(String username);
    User findByEmail(String email);

    List<User> findAll();
}