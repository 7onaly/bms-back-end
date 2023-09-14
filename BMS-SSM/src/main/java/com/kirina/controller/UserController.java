package com.kirina.controller;

import com.kirina.pojo.User;
import com.kirina.service.UserService;
import com.kirina.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("user")
@CrossOrigin
public class UserController {

    @Autowired
    private UserService userService;

    //登录
    @PostMapping("login")
    public Result login(@RequestBody User user){
        return userService.login(user);
    }

    //注册
    @PostMapping("register")
    public Result register(@RequestBody User user){
        return userService.register(user);
    }

}
