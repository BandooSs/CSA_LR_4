package com.example.LR_2.controllers;

import com.example.LR_2.models.Team;
import com.example.LR_2.service.TeamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class TeamController {
    private final TeamService teamService;
    @Autowired
    public TeamController(TeamService teamService) {
        this.teamService = teamService;
    }

    /*@GetMapping("/teams")
    public String home(Model model){
        List<Team> allTeams = teamService.findAll();
        model.addAttribute("allTeams",allTeams);
        return "teamsPage";
    }
    @PostMapping("/add-team")
    public String  createTeam(@ModelAttribute Team newTeam, Model model){
        teamService.saveTeam(newTeam);
        return home(model);
    }*/
}
