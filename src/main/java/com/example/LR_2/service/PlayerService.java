package com.example.LR_2.service;

import com.example.LR_2.models.Player;
import com.example.LR_2.repository.PlayerRepository;
import com.example.LR_2.requests.PlayerCreatReq;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PlayerService {
    private final PlayerRepository playerRepository;
    @Autowired
    public PlayerService(PlayerRepository playerRepository) {
        this.playerRepository = playerRepository;
    }

    public List<Player> finAll(){
        return playerRepository.findAll();
    }
    public Player savePlayer(Player newPlayer) {
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
        playerRepository.deleteById(id_player);
    }

}
