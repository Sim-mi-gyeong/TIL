package com.example.SessionLoginTest.controller;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.example.SessionLoginTest.model.SecurityUser;

@Controller
public class HomeController {

	// @GetMapping("/")
	// public String home() {
	// 	return "index";
	// }

	// @GetMapping("/")
	// public String homeV1(Authentication authentication, Model model) {
	// 	if (authentication != null) {
	// 		SecurityUser securityUser = (SecurityUser)authentication.getPrincipal();
	// 		model.addAttribute("principal", securityUser.getMember());
	// 		model.addAttribute("role", securityUser.getMember().getRole().getDescription());
	// 	}
	//
	// 	return "home";
	// }

	@GetMapping("/")
	public String home(@AuthenticationPrincipal SecurityUser securityUser, Model model) {
		if (securityUser != null) {
			model.addAttribute("principal", securityUser.getMember());
			model.addAttribute("role", securityUser.getMember().getRole().getDescription());
		}

		return "home";
	}

}
