package com.example.jwt.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.jwt.entity.Participants;
import com.example.jwt.repositories.ParticipantsRepository;

@Service
public class ParticipantService {

	  @Autowired
	    private ParticipantsRepository participantRepository;

	    public List<Participants> getJoinedParticipants(String meetingId) {
	        return participantRepository.findByMeetingId(meetingId);
	    }

	    public void removeParticipant(int participantId) {
	        participantRepository.deleteById(participantId);
	    }
}
