package com.sdProject.scoreDEI.Player;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PlayerService {

    @Autowired
    private PlayerRepository playerRepository;

    public void addUser(Player player) {
        playerRepository.save(player);
    }
}
