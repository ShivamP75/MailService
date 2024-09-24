package com.example.mail.service;

import org.apache.logging.log4j.message.Message;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class EmailService {
	
//	private final Logger logger = new Logger
	
	
	private JavaMailSender javaMailSender;
	
	@Value("${spring.mail.username}")
	private String from;
	
	@Autowired
	public EmailService(JavaMailSender javaMailSender) {
		// TODO Auto-generated constructor stub
		this.javaMailSender = javaMailSender;
	}
	
	public void sendMail(String to, String subject, String body) throws MailException {
		try {
			SimpleMailMessage mailMessage = new SimpleMailMessage();
			mailMessage.setTo(to);
			mailMessage.setSubject(subject);
			mailMessage.setFrom(from);
			mailMessage.setText(body);
			
			javaMailSender.send(mailMessage);
			
		} catch (MailException e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
			
		}
		
	}
	
	

}
