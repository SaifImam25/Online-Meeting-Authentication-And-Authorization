package com.example.jwt.entity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="Participants")

public class Participants {

	 @Id
	 @Column(name="pid",length=40)
	    private int pid;
	 @Column(name="meetingId",length=40)
        private String meetingId;
	 @Column(name="email",length=40)
	    private String email;
	 
	public Participants(int pid, String meetingId, String email) {
		this.pid = pid;
		this.meetingId = meetingId;
		this.email = email;
	}

	public Participants() {
	}

	public int getPid() {
		return pid;
	}

	public void setPid(int pid) {
		this.pid = pid;
	}

	public String getMeetingId() {
		return meetingId;
	}

	public void setMeetingId(String meetingId) {
		this.meetingId = meetingId;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public String toString() {
		return "Participants [pid=" + pid + ", meetingId=" + meetingId + ", email=" + email + "]";
	}

	
	 
	
	 
}
