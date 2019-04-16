package com.danmoop.ketarnio.Main.DAO;

import com.danmoop.ketarnio.Main.Interface.UserInterface;
import com.danmoop.ketarnio.Main.Service.UserService;
import com.danmoop.ketarnio.Main.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserDAO implements UserInterface
{
    @Autowired
    private UserService userService;

    @Override
    public void save(User user)
    {
        userService.save(user);
    }

    @Override
    public User findByUsername(String username)
    {
        return userService.findByUsername(username);
    }

    @Override
    public User findByEmail(String email)
    {
        return userService.findByEmail(email);
    }

    @Override
    public List<User> findAll()
    {
        return userService.findAll();
    }
}