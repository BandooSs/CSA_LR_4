package com.example.LR_2.controllers;
import com.example.LR_2.models.Player;
import com.example.LR_2.models.Player;
import com.example.LR_2.models.Team;
import com.example.LR_2.service.PlayerService;
import java.util.List;
import java.util.Optional;

import com.example.LR_2.service.TeamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class PlayerController {
    private final PlayerService playerService;
    private final TeamService teamService;
    @Autowired
    public PlayerController(PlayerService playerService,TeamService teamService) {

        this.playerService = playerService;
        this.teamService = teamService;
    }

    @GetMapping("/players")
    public String home(Model model){
        List<Player> allPlayers = playerService.finAll();
        model.addAttribute("allPlayers",allPlayers);
        return "playersPage";
    }

    @PostMapping("/add-player")
    public String  createTeam(@ModelAttribute Player newPlayer, @RequestParam("id_team") Long id_team, Model model){
        Team team = teamService.findById(id_team);
        newPlayer.setTeam(team);

        playerService.savePlayer(newPlayer);
        return home(model);
    }
}
