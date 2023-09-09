package com.example.jwt.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;
import com.example.jwt.entity.InvitedEmails;

public interface InvitedEmailsRepository extends JpaRepository<InvitedEmails, Integer> {
    List<InvitedEmails> findByEmail(String email);
   
    
}
