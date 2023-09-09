package com.example.jwt.controllers;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

//import com.example.jwt.entity.EmailRequest;
import jakarta.servlet.http.HttpSession;

import com.example.jwt.entity.Meeting;
import com.example.jwt.entity.Otp;
import com.example.jwt.entity.Users;
import com.example.jwt.repositories.MeetingRepository;
import com.example.jwt.repositories.UserRepository;
import com.example.jwt.service.EmailService;
import com.example.jwt.service.MeetingService;

//import jakarta.mail.Session;

@RestController

public class EmailController {
	
	Otp otp;
	
	@Autowired
	private EmailService emailotpService;
	@Autowired
	private UserRepository userRepo;
	@Autowired
	private  MeetingService meetService;
	
	
	//api to send email
	@RequestMapping(value= "/sendOtpemail",method = RequestMethod.POST)
	public String sendEmail(@RequestParam String email,HttpSession session){
		
		Users user = userRepo.findByEmail(email);
		  if (user == null  ) {
	            return "You are not authorized to join the meeting";
	        }
	      
	        otp = emailotpService.generateOtp();
	        String subject = "OTP Verification, Expire in 5 minutes!";
	        
	        String body = "<p>Hello " + user.getUsername() + "</p>"
	                + "<p>For security reason, you're required to use the following "
	                + "One Time Password to join the meeting:</p>"
	                + "<p><b>" + otp.getValue() + "</b></p>"
	                + "<br>"
	                + "<p>Note: this OTP is set to expire in 5 minutes.</p>";
	     boolean flag =  this.emailotpService.sendEmail(email, subject, body);
	        if(flag) {
	        	session.setAttribute("myOtp", otp.getValue());
	        	session.setAttribute("Email", email);
	        return "OTP generated and sent to " + email;
	        }
	        else
	        {   
	        	return "Check your email id!!";
	        	
	     }
	        
	}
	
	  @PostMapping("/verifyOtp")
	    public String verifyOtp(@RequestParam String otpValue,HttpSession session) {
		  
		  if (otp.getExpirationTime().isBefore(LocalDateTime.now())) {
			    return "OTP has expired. Please request a new OTP.";
			}
		  
		  String myOtp =  (String) session.getAttribute("myOtp");
	      String email = (String) session.getAttribute("Email");
		
		  
	       if(myOtp.equals(otpValue)){
	        return "OTP verified successfully.";
	        }
	       else {
	        	return "Invalid Otp";
	        }
	    }
		
		//return ResponseEntity.ok("Done...");
	}

