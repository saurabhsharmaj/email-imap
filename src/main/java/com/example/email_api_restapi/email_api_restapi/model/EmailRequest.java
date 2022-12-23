package com.example.email_api_restapi.email_api_restapi.model;

public class EmailRequest {
	String to;
	String message;
	//String from;
	String subject;
	public EmailRequest() {
		super();
		// TODO Auto-generated constructor stub
	}
	public EmailRequest(String to, String message, String from, String subject) {
		super();
		this.to = to;
		this.message = message;
		//this.from = from;
		this.subject = subject;
	}
	public String getTo() {
		return to;
	}
	public void setTo(String to) {
		this.to = to;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
	@Override
	public String toString() {
		return "EmailRequest [to=" + to + ", message=" + message + ", subject=" + subject + "]";
	}
	
	
	

}
