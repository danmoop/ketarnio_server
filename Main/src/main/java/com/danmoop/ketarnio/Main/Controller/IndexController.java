package com.danmoop.ketarnio.Main.Controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@CrossOrigin
@RestController
public class IndexController
{
    @GetMapping("/getuuid")
    public String uuid()
    {
        return UUID.randomUUID().toString();
    }
}