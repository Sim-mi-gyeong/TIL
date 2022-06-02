package com.example.SchedulerAppTest_Springboot.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.*;

@Entity
@Getter @Setter
public class User {

    @Id @GeneratedValue
    @Column(name="identity")
    private Long identity;

    private String name;

    private String id;

    private String password;

    private String passwordCheck;
}
