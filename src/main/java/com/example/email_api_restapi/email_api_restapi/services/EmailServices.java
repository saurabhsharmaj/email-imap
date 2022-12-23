package com.example.email_api_restapi.email_api_restapi.services;

import java.io.File;
import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

import org.springframework.stereotype.Service;

@Service
public class EmailServices {
	public boolean sendEmail(String to, String message, String subject)
	{
				String from="nikskhandelwal0405@gmail.com";
				boolean flag= false;
				//gmail variable
				
				String host = "smtp.gmail.com";
				//get system porperties
				Properties properties= System.getProperties();
				
				System.out.println(properties);
				
				//setting information to properties
				
				properties.put("mail.smtp.host",host);
				properties.put("mail.smtp.port","465");
				properties.put("mail.smtp.ssl.enable","true");
				properties.put("mail.smtp.auth","true");
				properties.put("mail.smtp.starttls.enable", "true");
				
				//step1: get the session object
				
				
				Session session= Session.getInstance(properties, new Authenticator() {
					
					@Override
					protected PasswordAuthentication getPasswordAuthentication() {
					
						return new PasswordAuthentication("email-address", "password"); 
					}	
				});
				
				session.setDebug(true);
				
				//step2: compose the message
				
				MimeMessage m =new MimeMessage(session);
				
				try {
					m.setFrom( new InternetAddress(from));
					m.addRecipient(Message.RecipientType.TO, new InternetAddress(to));
					m.setSubject(subject);
					m.setText(message); 
					
					//send attachment
					/*String path="C:\\Users\\ok\\Desktop\\niks\\img.png";
					MimeMultipart mimeMultipart= new MimeMultipart();
					
					MimeBodyPart textmime =new MimeBodyPart(); //for text
					MimeBodyPart filemime =new MimeBodyPart(); //for file
					
					try {
						textmime.setText(message);
						File file=new File(path);
						filemime.attachFile(file);
						mimeMultipart.addBodyPart(textmime);
						mimeMultipart.addBodyPart(filemime);
					}
					catch(Exception e) {
						e.printStackTrace();
					}
					
					m.setContent(mimeMultipart);
				*/	
					//sending message using Transport class
					
					Transport.send(m);
					flag=true;
					
					System.out.println("Email Sent");
					
				}
				catch(Exception e) {
					e.printStackTrace();
				
				}
				return flag;
			}
	}


