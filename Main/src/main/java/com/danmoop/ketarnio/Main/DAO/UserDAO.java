package com.danmoop.ketarnio.Main.DAO;

import com.danmoop.ketarnio.Main.Interface.UserInterface;
import com.danmoop.ketarnio.Main.Service.UserService;
import com.danmoop.ketarnio.Main.model.UserModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserDAO implements UserInterface
{
    @Autowired
    private UserService userService;

    @Override
    public void save(UserModel userModel)
    {
        userService.save(userModel);
    }

    @Override
    public UserModel findByUsername(String username)
    {
        return userService.findByUsername(username);
    }

    @Override
    public UserModel findByEmail(String email)
    {
        return userService.findByEmail(email);
    }

    @Override
    public List<UserModel> findAll()
    {
        return userService.findAll();
    }
}