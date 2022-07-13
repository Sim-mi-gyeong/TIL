package com.example.SessionLoginTest.enumeration;

import lombok.Getter;

// spring security 가 제공하는 ROLE 네이밍 정책 : ROLE_권한
@Getter
public enum Role {

	ROLE_ADMIN("관리자"), ROLE_MANAGER("매니저"), ROLE_MEMBER("일반사용자");

	private String description;

	Role(String description) {
		this.description = description;
	}

}
