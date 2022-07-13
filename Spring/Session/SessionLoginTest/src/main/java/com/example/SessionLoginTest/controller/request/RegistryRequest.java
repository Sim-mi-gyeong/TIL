package com.example.SessionLoginTest.controller.request;

import com.example.SessionLoginTest.enumeration.Role;

import lombok.Getter;
import lombok.Setter;

// view 와 controller 간 데이터 인터페이싱을 위해 사용한 요청 객체
@Getter @Setter
public class RegistryRequest {

	private String userName;
	private String userPassword;
	private Role role = Role.ROLE_MEMBER;

}
