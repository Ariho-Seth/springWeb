package com.ariho.spring.springweb.controllers;

import com.ariho.spring.springweb.dto.ClubDTO;
import com.ariho.spring.springweb.models.Club;
import com.ariho.spring.springweb.services.ClubService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class ClubController {

    private ClubService clubService;

    @Autowired
    public ClubController(ClubService clubService){
        this.clubService = clubService;
    }

    @GetMapping("/clubs")
    public String getAllClubs(Model model){
        List<ClubDTO> clubs= clubService.findAllClubs();
        model.addAttribute("clubs", clubs);

        return "clubsList";
    }

    @GetMapping("/clubs/new")
    public String createClubForm(Model model){
        Club club = new Club();
        model.addAttribute("club", club);
        return "clubsCreate";
    }

    @PostMapping("/clubs/new")
    public String saveClub(@ModelAttribute("clubs") Club club){
        clubService.saveClub(club);
        return "redirect:/clubs";
    }

}
