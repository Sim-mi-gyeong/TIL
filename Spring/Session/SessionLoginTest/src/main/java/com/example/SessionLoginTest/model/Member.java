package com.example.SessionLoginTest.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.example.SessionLoginTest.enumeration.Role;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "member")
@Getter @Setter
@NoArgsConstructor
public class Member {

	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "user_id")
	private Long id;

	@Column(name = "user_name")
	private String userName;

	@Column(name = "user_password")
	private String userPassword;

	@Column(name = "enabled", columnDefinition = "TINYINT(1)")
	private boolean enabled;

	@Enumerated(EnumType.STRING)
	private Role role;

	@Builder
	public Member(String userName, String userPassword, boolean enabled, Role role) {
		this.userName = userName;
		this.userPassword = userPassword;
		this.enabled = enabled;
		this.role = role;
	}

}
