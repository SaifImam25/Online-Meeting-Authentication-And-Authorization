package com.example.jwt.service;

//import java.io.UnsupportedEncodingException;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.Properties;

import jakarta.mail.Authenticator;
import jakarta.mail.Message;
//import jakarta.mail.MessagingException;
import jakarta.mail.PasswordAuthentication;
import jakarta.mail.Session;
import jakarta.mail.Transport;
import jakarta.mail.internet.InternetAddress;
import jakarta.mail.internet.MimeMessage;

import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.stereotype.Service;

import com.example.jwt.entity.Otp;

@Service
public class EmailService {

	private static final int OTP_EXPIRATION_MINUTES = 5;
	public Otp generateOtp() {
		
		String OTP = RandomStringUtils.randomAlphanumeric(6);
		
		LocalDateTime expirationTime = LocalDateTime.now().plus(OTP_EXPIRATION_MINUTES, ChronoUnit.MINUTES);
        
        return  new Otp(OTP, expirationTime );
	}
	
	public boolean sendEmail(String to,String subject,String body) {
		
		boolean f=false;
		
		String from = "imamsaif.mariner@gmail.com";
		
		String host= "smtp.gmail.com";
		Properties properties = System.getProperties();
		
		//host set
		properties.put("mail.smtp.host", host);
		properties.put("mail.smtp.port", "465");
		properties.put("mail.smtp.ssl.enable","true");
		properties.put("mail.smtp.auth","true");
		
		//to get session
		Session session=Session.getInstance(properties, new Authenticator() {
			@Override
			protected PasswordAuthentication getPasswordAuthentication() {				
				return new PasswordAuthentication("imamsaif.mariner@gmail.com", "pewpzgeswofuclmy");
			}
			
		});
		
session.setDebug(true);
		
		//Step 2 : compose the message [text,multi media]
		MimeMessage m = new MimeMessage(session);
		
		try {
		
		//from email
		m.setFrom(from);
		
		//adding recipient to message
		m.addRecipient(Message.RecipientType.TO, new InternetAddress(to));
		
		//adding subject to message
		m.setSubject(subject);
		
		m.setText(body);
		m.setContent(body, "text/html");
		Transport.send(m);
		System.out.println("Sent Success");
		f=true;
	}
		catch(Exception e) {
		e.printStackTrace();
		}
		return f;
	}
	
}
