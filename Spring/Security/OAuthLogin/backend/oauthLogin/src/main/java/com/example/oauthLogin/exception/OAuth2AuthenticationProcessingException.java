package com.example.oauthLogin.exception;

import javax.naming.AuthenticationException;

public class OAuth2AuthenticationProcessingException extends AuthenticationException {

	public OAuth2AuthenticationProcessingException(String msg) {
		super(msg);
	}
}
