package com.example.SwaggerTest.controller;

import io.swagger.annotations.ApiOperation;
import io.swagger.v3.oas.annotations.Parameter;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/")
public class ApiController {

    @GetMapping("/")
    public String home() {
        return "index";
    }

    @GetMapping(value = "test", produces = MediaType.TEXT_PLAIN_VALUE)
    @ApiOperation(value = "Test Sample")   // API 에 대한 설명 - value : 태
    public Object sampleController(@Parameter(hidden=true) @RequestParam String param) {
        return ResponseEntity.ok(param);
    }
}
