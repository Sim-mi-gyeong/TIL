package com.example.SessionLoginTest.controller.request;

import com.example.SessionLoginTest.enumeration.Role;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class LoginRequest {

	private String userName;
	private String userPassword;
	private Role role;
}
