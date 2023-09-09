package com.example.jwt.entity;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name="Meetings")
public class Meeting {

	 @Id
	 @Column(name="meetingId",length=40)
	    private String meetingId;
	 @Column(name="hostId",length=40)
	    private int hostId;
	 
	public Meeting(String meetingId, int hostId) {
		this.meetingId = meetingId;
		this.hostId = hostId;
	}

	public Meeting() {
	}

	public String getMeetingId() {
		return meetingId;
	}

	public void setMeetingId(String meetingId) {
		this.meetingId = meetingId;
	}

	public int getHostId() {
		return hostId;
	}

	public void setHostId(int hostId) {
		this.hostId = hostId;
	}

	@Override
	public String toString() {
		return "Meeting [meetingId=" + meetingId + ", hostId=" + hostId + "]";
	}

	 
	 
}
