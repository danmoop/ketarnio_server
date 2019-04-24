package com.danmoop.ketarnio.Main.Controller;

import com.danmoop.ketarnio.Main.DAO.UserDAO;
import com.danmoop.ketarnio.Main.model.UserModel;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;

@CrossOrigin
@RestController
public class UserDashboardController
{
    @Autowired
    private UserDAO userDAO;

    @PostMapping("/setUserNote")
    public void setNote(Principal principal, @RequestBody Object note)
    {
        JSONObject object = Misc.getJSON(note);

        UserModel user = userDAO.findByUsername(principal.getName());
        user.setNote(object.get("text").toString());
        userDAO.save(user);
    }

    @GetMapping("/refreshUserProfile")
    public UserModel user(Principal principal)
    {
        return userDAO.findByUsername(principal.getName());
    }
}