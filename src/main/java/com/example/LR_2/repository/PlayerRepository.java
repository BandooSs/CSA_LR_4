package com.example.LR_2.repository;

import com.example.LR_2.models.Player;
import com.example.LR_2.models.Team;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PlayerRepository extends JpaRepository<Player, Long> {
}
