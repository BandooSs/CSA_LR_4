package com.example.LR_2.service;

import com.example.LR_2.models.AuditEvent;
import com.example.LR_2.models.Player;
import com.example.LR_2.models.Team;
import com.example.LR_2.repository.TeamRepository;
import com.example.LR_2.requests.TeamCreatReq;
import com.example.LR_2.utils.EventLogger;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class TeamService {
    private final TeamRepository teamRepository;
    private final EventLogger eventLogger;

    public List<Team> findAll(){
        return teamRepository.findAll();
    }

    public Team saveTeam(Team newteam){
        return teamRepository.save(newteam);
    }

    public Team findById(Long idTeam) {
        return teamRepository.getOne(idTeam);
    }

    public void deleteTeam(Long id_team){
        eventLogger.log(teamRepository.findById(id_team), AuditEvent.DELETE);
        teamRepository.deleteById(id_team);
    }
    public void createTeam(TeamCreatReq newTeam) {


        Team team = new Team();
        team.setFirst_name(newTeam.getFirst_name());
        team.setCity_name(newTeam.getCity_name());



        teamRepository.save(team);
    }
}
