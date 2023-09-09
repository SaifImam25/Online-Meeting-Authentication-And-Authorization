package com.example.jwt.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.jwt.entity.Meeting;

public interface MeetingRepository  extends JpaRepository<Meeting, String> {
    Meeting findByMeetingId(String meetingId);
    

}
