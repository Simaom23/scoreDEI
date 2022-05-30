package com.sdProject.scoreDEI.Team;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface TeamRepository extends CrudRepository<Team, Integer> {
    @Transactional
    @Modifying
    @Query("UPDATE Team t SET t.games = t.games + 1 WHERE id = :id")
    void addGames(int id);

    @Transactional
    @Modifying
    @Query("UPDATE Team t SET t.wins = t.wins + 1 WHERE id = :id")
    void addWins(int id);

    @Transactional
    @Modifying
    @Query("UPDATE Team t SET t.losses = t.losses + 1 WHERE id = :id")
    void addLosses(int id);

    @Transactional
    @Modifying
    @Query("UPDATE Team t SET t.defeats = t.defeats + 1 WHERE id = :id")
    void addDefeats(int id);

    @Query("SELECT t FROM Team t ORDER BY name DESC")
    List<Team> getTeamsDescending();

    @Query("SELECT t FROM Team t ORDER BY name ASC")
    List<Team> getTeamsAscending();

    @Query("SELECT t FROM Team t ORDER BY games DESC")
    List<Team> getGamesDescending();

    @Query("SELECT t FROM Team t ORDER BY games ASC")
    List<Team> getGamesAscending();

    @Query("SELECT t FROM Team t ORDER BY wins DESC")
    List<Team> getWinsDescending();

    @Query("SELECT t FROM Team t ORDER BY wins ASC")
    List<Team> getWinsAscending();

    @Query("SELECT t FROM Team t ORDER BY losses DESC")
    List<Team> getLossesDescending();

    @Query("SELECT t FROM Team t ORDER BY losses ASC")
    List<Team> getLossesAscending();

    @Query("SELECT t FROM Team t ORDER BY defeats DESC")
    List<Team> getDefeatsDescending();

    @Query("SELECT t FROM Team t ORDER BY defeats ASC")
    List<Team> getDefeatsAscending();
}
