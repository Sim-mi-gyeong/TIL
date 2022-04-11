package com.example.SchedulerAppTest_Springboot.param;

import lombok.Data;

@Data
public class UserSignUpRequestParam {

    private String name;

    private String id;

    private String password;

    private String passwordCheck;
}
