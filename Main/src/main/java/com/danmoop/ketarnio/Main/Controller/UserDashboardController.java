package com.danmoop.ketarnio.Main.Controller;

import com.danmoop.ketarnio.Main.DAO.UserDAO;
import com.danmoop.ketarnio.Main.model.InboxMessage;
import com.danmoop.ketarnio.Main.model.UserModel;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.Date;

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

    @GetMapping("/clearUserInbox")
    public UserModel clearUserInbox(Principal principal)
    {
        UserModel user = userDAO.findByUsername(principal.getName());

        user.clearInbox();

        userDAO.save(user);

        return user;
    }

    @PostMapping("/sendMessageToUser")
    public String sendMessageToUser(Principal principal, @RequestBody Object object)
    {
        String username = Misc.getJSON(object).get("recipient").toString();

        String messageContent = Misc.getJSON(object).get("message").toString();

        UserModel recipient = userDAO.findByUsername(username);

        if(recipient != null)
        {
            recipient.addInboxMessage(new InboxMessage(principal.getName(), messageContent, new Date().toString()));
            userDAO.save(recipient);

            return "Done!";
        }

        return username + " is not found";
    }
}