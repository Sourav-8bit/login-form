package com.loginForm.loginForm.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.loginForm.loginForm.model.EmailRequest;
import com.loginForm.loginForm.services.EmailServices;

@RestController
public class LoginController {
	@Autowired
	EmailServices emailService;

	@GetMapping("/hello")
	public String sayHello()
	{
		return "hello";
	}
	
	@PostMapping("/sendmail")
	public void sendMail(@RequestBody EmailRequest emailRequest) {
		
		System.out.println("---------------------test--------------------");
		System.out.println(emailRequest);
		this.emailService.sendEmail(emailRequest.getTo(),emailRequest.getMessage(),emailRequest.getSubject());
	}
	
	
}
