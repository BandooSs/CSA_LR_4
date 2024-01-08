package com.example.LR_2.service;

import com.example.LR_2.models.Team;
import com.example.LR_2.repository.TeamRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TeamService {
    private final TeamRepository teamRepository;
    @Autowired
    public TeamService(TeamRepository teamRepository) {
        this.teamRepository = teamRepository;
    }

    public List<Team> findAll(){
        return teamRepository.findAll();
    }

    public Team saveTeam(Team newteam){
        return teamRepository.save(newteam);
    }

    public Team findById(Long idTeam) {
        return teamRepository.getOne(idTeam);
    }
}
