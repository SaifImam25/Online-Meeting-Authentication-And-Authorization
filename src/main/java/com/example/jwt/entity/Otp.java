package com.example.jwt.entity;

import java.time.LocalDateTime;



public class Otp {

        private String value;
	    private LocalDateTime expirationTime;

	    public Otp(String value, LocalDateTime expirationTime) {
	        this.value = value;
	        this.expirationTime = expirationTime;
	    }

	    public String getValue() {
	        return value;
	    }

	    public LocalDateTime getExpirationTime() {
	        return expirationTime;
	    }
	}


