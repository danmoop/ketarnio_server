package com.danmoop.ketarnio.Main.Controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin
@RestController
public class IndexController
{
    // we send a request from a frontend page check if the server is running
    @GetMapping("/checkServer")
    public String isRunning()
    {
        return "running";
    }
}