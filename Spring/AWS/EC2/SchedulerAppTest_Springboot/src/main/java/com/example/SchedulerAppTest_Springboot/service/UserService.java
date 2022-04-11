package com.example.SchedulerAppTest_Springboot.service;

import com.example.SchedulerAppTest_Springboot.domain.User;
import com.example.SchedulerAppTest_Springboot.param.UserSignUpRequestParam;

public interface UserService {

    public Long signUp(User user);

    public void validateDuplicateUser(User user);
}
