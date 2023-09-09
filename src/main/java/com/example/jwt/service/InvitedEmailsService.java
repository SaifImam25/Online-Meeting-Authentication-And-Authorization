package com.example.jwt.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.jwt.entity.InvitedEmails;
import com.example.jwt.entity.Meeting;
import com.example.jwt.repositories.InvitedEmailsRepository;


@Service
public class InvitedEmailsService {

    @Autowired
    private InvitedEmailsRepository invitedEmailsRepository;

    public void saveInvitedEmail(InvitedEmails email) {
    	 invitedEmailsRepository.save(email);
    }
       
        
    	public List<InvitedEmails> getemails() {
	        return invitedEmailsRepository.findAll() ;
    }
}
