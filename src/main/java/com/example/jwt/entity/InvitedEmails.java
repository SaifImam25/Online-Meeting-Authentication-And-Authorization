package com.example.jwt.entity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="InvitedMails")
public class InvitedEmails {

	 @Id
	 @Column(name="eid",length=40)
	 @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private int eid;
	 @Column(name="email",length=300)
	    private String email;
	 
	 
	public InvitedEmails(int eid, String email, String meetingId) {
		this.eid = eid;
		this.email = email;
		
	}

	public InvitedEmails() {
	}

	public int getEid() {
		return eid;
	}

	public void setEid(int eid) {
		this.eid = eid;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}


	@Override
	public String toString() {
		return "InvitedEmails [eid=" + eid + ", email=" + email  + "]";
	}
	   
	 

	   
	  
	}

