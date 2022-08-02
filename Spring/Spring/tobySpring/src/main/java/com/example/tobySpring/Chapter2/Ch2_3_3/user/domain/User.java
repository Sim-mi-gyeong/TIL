package com.example.tobySpring.Chapter2.Ch2_3_3.user.domain;


public class User {
	String id;
	String name;
	String password;

	/**
	 * 자바빈의 규약을 따르는 클래스에, 생성자를 명시적으로 추가했을 때는
	 * -> 파라미터가 없는 디폴트 생성자도 함께 정의해야 함!!
	 */
	public User() { }

	public User(String id, String name, String password) {
		this.id = id;
		this.name = name;
		this.password = password;
	}

	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
}