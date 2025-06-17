package com.ariho.spring.springweb.services;

import com.ariho.spring.springweb.dto.ClubDTO;
import com.ariho.spring.springweb.models.Club;

import java.util.List;

public interface ClubService {
    List<ClubDTO> findAllClubs();
    Club saveClub(Club club);


}
