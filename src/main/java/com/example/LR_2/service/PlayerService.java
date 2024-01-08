package com.example.LR_2.service;

import com.example.LR_2.models.Player;
import com.example.LR_2.repository.PlayerRepository;
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
}
