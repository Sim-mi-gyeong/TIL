package com.example.SessionLoginTest.model;

import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;

import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;

/**
 * Spring Security 가 제공하는 User 클래스를 Entity 클래스로 정의한 Member 로 사용하기 위해 커스텀
 * -> 이후, SecurityUser 를 통해 Member 에 접근할 것이므로, Member 를 필드로 갖게 하고 + 생성자를 통해 값을 유지
 * -> super 키워드를 통해 부모 클래스(User) 의 생성자로 userName, userPassword, role 을 넘겨줌
 */

@Slf4j
@Getter @Setter
public class SecurityUser extends User {

	private Member member;

	public SecurityUser(Member member) {
		super(member.getUserName(), member.getUserPassword(), AuthorityUtils.createAuthorityList(member.getRole().toString()));

		log.info("SecurityUser member.userName : {}", member.getUserName());
		log.info("SecurityUser member.userPassword : {}", member.getUserPassword());
		log.info("SecurityUser member.role : {}", member.getRole());

		this.member = member;
	}

}
