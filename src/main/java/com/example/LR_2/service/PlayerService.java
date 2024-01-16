package com.example.LR_2.service;

import com.example.LR_2.models.AuditEvent;
import com.example.LR_2.models.Player;
import com.example.LR_2.repository.PlayerRepository;
import com.example.LR_2.requests.PlayerCreatReq;
import com.example.LR_2.utils.EventLogger;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class PlayerService {
    private final PlayerRepository playerRepository;
    private final EventLogger eventLogger;


    public List<Player> finAll(){
        return playerRepository.findAll();
    }
    public Player savePlayer(Player newPlayer) {;
        return playerRepository.save(newPlayer);
    }


    public void savePlayer(PlayerCreatReq newPlayerReq){
        Player newPlayer = new Player();
        newPlayer.setFirst_name(newPlayerReq.getFirst_name());
        newPlayer.setLast_name(newPlayerReq.getLast_name());
//        newPlayer.setId_team(newPlayerReq.getId_team());
        playerRepository.save(newPlayer);
    }
    public void deletePlayer(long id_player){
        eventLogger.log(playerRepository.findById(id_player), AuditEvent.DELETE);
        playerRepository.deleteById(id_player);
    }

}
