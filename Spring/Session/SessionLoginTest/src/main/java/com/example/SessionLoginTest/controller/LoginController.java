package com.example.SessionLoginTest.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.example.SessionLoginTest.controller.request.LoginRequest;

@Controller
public class LoginController {

	@GetMapping("/login")
	public String loginForm(Model model) {
		model.addAttribute("member", new LoginRequest());
		return "login";
	}
}
