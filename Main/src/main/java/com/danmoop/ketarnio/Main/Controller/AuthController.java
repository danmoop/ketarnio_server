package com.danmoop.ketarnio.Main.Controller;

import com.danmoop.ketarnio.Main.DAO.UserDAO;
import com.danmoop.ketarnio.Main.model.UserModel;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.ArrayList;
import java.util.Date;

@CrossOrigin
@RestController
public class AuthController
{
    private ObjectMapper mapper = new ObjectMapper();

    @Autowired
    private UserDAO userDAO;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @GetMapping("/user")
    public UserModel user(Principal principal)
    {
        return userDAO.findByUsername(principal.getName());
    }

    @GetMapping("/loginRequest")
    public UserModel login(Principal principal)
    {
        UserModel userModel = userDAO.findByUsername(principal.getName());

        return userDAO.findByUsername(principal.getName());
    }

    @PostMapping("/signUp")
    public boolean isRegistered(@RequestBody UserModel userModel)
    {
        if(!userModel.areFieldsEmpty())
        {
            // password is set by a user
            userModel.setPassword(passwordEncoder.encode(userModel.getPassword()));

            // all other data is set automatically by server
            userModel.setTimeStamp(new Date().toString());
            userModel.setRole("user");
            userModel.setNote("");
            userModel.setMessages(new ArrayList<>());
            userModel.setTasks(new ArrayList<>());
            userModel.setProjects(new ArrayList<>());
            userModel.setProjectInvitations(new ArrayList<>());

            userDAO.save(userModel);

            return true;
        }

        return false;
    }
}