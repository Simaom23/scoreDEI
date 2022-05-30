package com.sdProject.scoreDEI.Player;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface PlayerRepository extends CrudRepository<Player, Integer> {
    @Transactional
    @Modifying
    @Query("UPDATE Player p SET p.goals = p.goals + 1 WHERE id = :id")
    void addGoal(int id);

    @Query("SELECT p FROM Player p ORDER BY name DESC")
    List<Player> getPlayersDescending();

    @Query("SELECT p FROM Player p ORDER BY name ASC")
    List<Player> getPlayersAscending();

    @Query("SELECT p FROM Player p ORDER BY goals DESC")
    List<Player> getGoalsDescending();

    @Query("SELECT p FROM Player p ORDER BY goals ASC")
    List<Player> getGoalsAscending();
}