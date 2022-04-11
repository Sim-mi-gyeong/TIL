package com.example.SchedulerAppTest_Springboot.controller;

import com.example.SchedulerAppTest_Springboot.domain.User;
import com.example.SchedulerAppTest_Springboot.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@Controller
public class SchedulerAppTestController {

    private UserService userService;

    @GetMapping(value = "/home")
    public String homepage() {
        return "home";
    }

    @PostMapping(value = "/user/signup")
    public Long SignUp(@Validated @RequestBody User user) {
        return userService.signUp(user);
    }

}
