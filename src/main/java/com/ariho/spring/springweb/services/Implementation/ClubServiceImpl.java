package com.ariho.spring.springweb.services.Implementation;

import com.ariho.spring.springweb.dto.ClubDTO;
import com.ariho.spring.springweb.models.Club;
import com.ariho.spring.springweb.repository.ClubRepository;
import com.ariho.spring.springweb.services.ClubService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ClubServiceImpl implements ClubService {

    private ClubRepository clubRepository;

    @Autowired
    public ClubServiceImpl(ClubRepository clubRepository) {
        this.clubRepository= clubRepository;
    }

    @Override
    public List<ClubDTO> findAllClubs(){

        List<Club> clubList= (List<Club>) clubRepository.findAll();

        return clubList.stream().map((club)-> mapToDTO(club)).collect(Collectors.toList());
    }

    @Override
    public Club saveClub(Club club) {
        return clubRepository.save(club);
    }

    private ClubDTO mapToDTO(Club club){

        return ClubDTO.builder()
                .id(club.getId())
                .title(club.getTitle())
                .photoUrl(club.getPhotoUrl())
                .content(club.getContent())
                .createdOn(club.getCreatedOn())
                .updatedOn(club.getUpdatedOn())
                .build();


    }

}
