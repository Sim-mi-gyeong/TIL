package com.example.SchedulerAppTest_Springboot.service;

import com.example.SchedulerAppTest_Springboot.domain.User;
import com.example.SchedulerAppTest_Springboot.param.UserSignUpRequestParam;
import com.example.SchedulerAppTest_Springboot.param.UserSignUpResponse;
import com.example.SchedulerAppTest_Springboot.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Required;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class UserServiceImpl implements UserService{
    private final UserRepository userRepository;
    private UserSignUpRequestParam userSignUpRequestParam;
    private UserSignUpResponse userSignUpResponse;

    @Transactional
    public Long signUp(User user) {
        validateDuplicateUser(user);   // 중복 회원 검증
        userRepository.save(user);
        userSignUpResponse.setCode(200);
        userSignUpResponse.setMessage("회원가입 성공");
        return user.getItentity();
    }

    public void validateDuplicateUser(User user) {
        // EXCEPTION
        List<User> findUsers = userRepository.findById(user.getId());
        if(!findUsers.isEmpty()) {
            throw new IllegalStateException("이미 존재하는 회원입니다.");
        }
    }
}
