package com.example.mail.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.mail.dto.Maildto;
import com.example.mail.service.EmailService;

import jakarta.validation.Valid;

@RestController
public class MailSendingController {
	
	/*
	 * JSON format
	 * {
    "to" : "xyz@gmail.com",
    "subject" : "testing_mail",
    "body" : "Hi XYZ, We are testing the mail"
}
	 */
	
	@Autowired
	private EmailService emailService;
	
	@GetMapping("/send-mail")
	public ResponseEntity<String> sendMail(@RequestBody @Valid Maildto maildto) {
		try {
			emailService.sendMail(maildto.getTo(), maildto.getSubject(), maildto.getBody());
			return new ResponseEntity<String>("Mail sent to " + maildto.getTo(), HttpStatus.OK);
			
		} catch (Exception e) {
			// TODO: handle exception
			return new ResponseEntity<String>(e.getMessage(), HttpStatus.BAD_REQUEST);
		}
		
	}

}
