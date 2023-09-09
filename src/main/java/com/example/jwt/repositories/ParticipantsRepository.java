package com.example.jwt.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.jwt.entity.Participants;

public interface ParticipantsRepository extends JpaRepository<Participants, Integer> {
    List<Participants> findByMeetingId(String meetingId);

}
