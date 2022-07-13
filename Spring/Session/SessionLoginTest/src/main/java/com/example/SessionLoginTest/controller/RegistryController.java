package com.example.SessionLoginTest.controller;

import java.util.LinkedHashMap;
import java.util.Map;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.SessionLoginTest.controller.request.RegistryRequest;
import com.example.SessionLoginTest.enumeration.Role;
import com.example.SessionLoginTest.model.Member;
import com.example.SessionLoginTest.repository.MemberRepository;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequiredArgsConstructor
@Controller
public class RegistryController {

	private final MemberRepository memberRepository;
	private final BCryptPasswordEncoder bCryptPasswordEncoder;

	@GetMapping("/registry")
	public String registryForm(Model model) {
		model.addAttribute("member", new RegistryRequest());
		return "registry";
	}

	@PostMapping("/registry")
	public String registry(@ModelAttribute RegistryRequest registryRequest) {
		Member member = Member.builder()
			.userName(registryRequest.getUserName())
			.userPassword(bCryptPasswordEncoder.encode(registryRequest.getUserPassword()))
			.role(registryRequest.getRole())
			.build();

		memberRepository.save(member);

		return "redirect:/login";
	}

	@ModelAttribute("roles")
	public Map<String, Role> roles() {
		Map<String, Role> map = new LinkedHashMap<>();
		map.put("관리자", Role.ROLE_ADMIN);
		map.put("매니저", Role.ROLE_MANAGER);
		map.put("일반 사용자", Role.ROLE_MEMBER);

		return map;
	}
}
