package com.example.jwt.controllers;

import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
//import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
//import com.example.jwt.entity.EmailRequest;
import jakarta.servlet.http.HttpSession;
import com.example.jwt.entity.Meeting;
import com.example.jwt.entity.Otp;
import com.example.jwt.entity.Users;
import com.example.jwt.repositories.InvitedEmailsRepository;
import com.example.jwt.repositories.UserRepository;
import com.example.jwt.service.EmailService;
import com.example.jwt.service.InvitedEmailsService;
import com.example.jwt.service.MeetingService;
import com.example.jwt.service.ParticipantService;
import com.example.jwt.entity.InvitedEmails;
import com.example.jwt.entity.Participants;

@RestController
@CrossOrigin

public class MeetingController {
	
	Meeting meetingid;
	@Autowired
    private MeetingService meetingService;
	@Autowired
	private ParticipantService participantsService;
	@Autowired
	private InvitedEmailsService inviEmails;
	@Autowired 
	private InvitedEmailsRepository allemails;
	@Autowired 
	private EmailService emailmidService;
	@Autowired
	private UserRepository userRepo;
	
	
	
	@PostMapping("/AddInvitees")

	// public ResponseEntity<InvitedEmails> saveInvitedEmail(@RequestBody String email) {
		public String addemails (@RequestBody InvitedEmails emails) {
		    inviEmails.saveInvitedEmail(emails);
		   return "invitee added successfully";
		}
        
    
	
	
	@PostMapping("/create")
	@ResponseBody
    public ResponseEntity<Meeting> meetingCreate( Meeting meeting,Users user) {
        List<InvitedEmails> invimails = inviEmails.getemails();
  
        int hostId = user.getUid();
		
		Meeting createdMeeting = meetingService.createMeeting(meeting,hostId);
		 
	        String subject = "Meeting Invite!";
	        
	        String body = "<p>Hello " + user.getUsername() + "</p>"
	                + "<p>This is an invite for joining the meeting"
	                + "	Meeting Id for this meeting is given below:</p>"
	                + "<p><b>" + meeting.getMeetingId() + "</b></p>"
	                + "<br>"
	                + "<p>Respondez s'il vous plait</p>";
	        
	        List<String> emailAddresses = invimails.stream()
	                .map(InvitedEmails::getEmail)
	                .collect(Collectors.toList());
	        for (String emailAddress : emailAddresses) {
	            emailmidService.sendEmail(emailAddress, subject, body);
	        }
        return ResponseEntity.status(HttpStatus.CREATED).body(createdMeeting);
    }
	
	@DeleteMapping("/end")
    public ResponseEntity<String> endMeeting(@RequestBody Meeting meetingId) {
	   String meetid = meetingId.getMeetingId();
        meetingService.endMeeting(meetid);
        return ResponseEntity.ok("Meeting ended successfully.");
    }
	
	  @GetMapping("/participants")
	    public ResponseEntity<List<Participants>> JoinedParticipants(@RequestBody Participants meetingId) {
		  String mid = meetingId.getMeetingId();
	        List<Participants> participants = participantsService.getJoinedParticipants(mid);
	        return ResponseEntity.ok(participants);
	    }
	  @DeleteMapping("/leave")
	  public ResponseEntity<String> removeParticipant(@RequestBody Participants participant) {
	      int participantId =  participant.getPid();
		  participantsService.removeParticipant(participantId);
	        return ResponseEntity.ok("Participant removed from the meeting.");
	    }
}
