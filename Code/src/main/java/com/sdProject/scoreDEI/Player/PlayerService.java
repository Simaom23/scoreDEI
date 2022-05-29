package com.sdProject.scoreDEI.Player;

import java.util.List;
import java.util.Optional;

import com.sdProject.scoreDEI.Team.Team;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PlayerService {

    @Autowired
    private PlayerRepository playerRepository;

    public void addPlayer(Player player) {
        playerRepository.save(player);
    }

    public void deletePlayer(Player player) {
        playerRepository.delete(player);
    }

    public Optional<Player> getPlayer(int id) {
        return playerRepository.findById(id);
    }

    public List<Player> getAllPlayers() {
        List<Player> players = new ArrayList<>();
        playerRepository.findAll().forEach(players::add);
        return players;
    }

    public List<Player> getTeamPlayers(Team team) {
        List<Player> players = new ArrayList<>();
        playerRepository.findPlayersTeam(team);
        return players;
    }
}
