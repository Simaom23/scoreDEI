package com.sdProject.scoreDEI.Game;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GameService {

    @Autowired
    private GameRepository gameRepository;

    public void addGame(Game game) {
        gameRepository.save(game);
    }
}
