package com.example.jwt.service;

import java.util.UUID;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.jwt.entity.Meeting;
import com.example.jwt.repositories.MeetingRepository;

@Service
public class MeetingService {

	 @Autowired
	    private MeetingRepository meetingRepository;

	    public Meeting createMeeting(Meeting meeting, int hostId) {
	        // Generate a unique meetingId and set other properties
	    	meeting.setHostId(hostId);
	        meeting.setMeetingId(UUID.randomUUID().toString());
	        return meetingRepository.save(meeting);
	    }
	    
	    public Meeting getMeetingById(String meetingId) {
	        return meetingRepository.findByMeetingId(meetingId);
	    }


	    public void endMeeting(String meetingId) {
	        Meeting meeting = meetingRepository.findByMeetingId(meetingId);           
	        if (meeting != null) {
	            meetingRepository.delete(meeting);
	        }
	       
	    }
}
