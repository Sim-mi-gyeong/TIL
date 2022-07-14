package com.example.SessionLoginTest.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
public class ExceptionController {

	@GetMapping("/forbidden")
	public String exceptionHandling() {
		return "forbidden";
	}
}
