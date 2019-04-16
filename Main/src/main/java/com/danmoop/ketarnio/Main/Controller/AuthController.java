package com.danmoop.ketarnio.Main.Controller;

import com.danmoop.ketarnio.Main.DAO.UserDAO;
import com.danmoop.ketarnio.Main.Service.UserService;
import com.danmoop.ketarnio.Main.model.User;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.Date;

@CrossOrigin
@RestController
public class AuthController
{
    @Autowired
    private UserDAO userDAO;

    private ObjectMapper mapper = new ObjectMapper();

    @PostMapping("/signIn")
    public User user(@RequestBody Object object) throws IOException
    {
        JSONObject jsonObject = Misc.getJSON(object);

        System.out.println(jsonObject);

        User user = mapper.readValue(jsonObject.toString(), User.class);

        user.setTimeStamp(new Date().toString());
        user.setEmail("none");

        return user;
    }

    @PostMapping("/signUp")
    public String registration(@RequestBody User user) throws IOException
    {
        System.out.println(user.toString());

        user.setTimeStamp(new Date().toString());

        userDAO.save(user);

        return "success";
    }
}