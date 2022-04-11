package com.example.SchedulerAppTest_Springboot.repository;

import com.example.SchedulerAppTest_Springboot.domain.User;
import com.example.SchedulerAppTest_Springboot.param.UserSignUpRequestParam;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.List;

@Repository
@RequiredArgsConstructor
public class UserRepository {

    private final EntityManager em;

    public void save(User user) {
        em.persist(user);
    }

    public List<User> findById(String id) {
        return em.createQuery("select user from User where user.id = :id ", User.class)
                .setParameter("id", id)
                .getResultList();
    }
}
