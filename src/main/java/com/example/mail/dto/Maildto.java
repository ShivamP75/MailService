package com.example.mail.dto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;


public class Maildto {
	
	@NotNull
	@Pattern(regexp = "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+.[A-Za-z]{2,6}$", message = "Email id is incorrect")
	private String to;
	
	private String subject;
	
	private String body;
	
	
	public Maildto(String to, String subject, String body) {
		super();
		this.to = to;
		this.subject = subject;
		this.body = body;
	}

	public String getTo() {
		return to;
	}

	public void setTo(String to) {
		this.to = to;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public String getBody() {
		return body;
	}

	public void setBody(String body) {
		this.body = body;
	}
	
	

}
