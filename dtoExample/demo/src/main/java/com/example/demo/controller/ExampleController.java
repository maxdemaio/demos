package com.example.demo.controller;

import javax.validation.Valid;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.PersonDTO;


@RestController
public class ExampleController {
	@PostMapping("/")
	public String checkPersonInfo(@Valid @RequestBody PersonDTO personDTO) {
		return "Valid person DTO!";
	}
}
