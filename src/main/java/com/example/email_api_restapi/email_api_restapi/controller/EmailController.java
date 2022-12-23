package com.example.email_api_restapi.email_api_restapi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.email_api_restapi.email_api_restapi.model.EmailRequest;
import com.example.email_api_restapi.email_api_restapi.services.EmailServices;

@RestController
public class EmailController {
	@Autowired
	EmailServices emailServices;

	@PostMapping("/sendemail")
	public void sendEmail(@RequestBody EmailRequest request){
		System.out.println(request);
		this.emailServices.sendEmail(request.getTo(),request.getMessage(),request.getSubject());
	}
}
