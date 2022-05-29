package com.sdProject.scoreDEI.Player;

import java.util.List;

import com.sdProject.scoreDEI.Team.Team;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface PlayerRepository extends CrudRepository<Player, Integer> {
    @Query("SELECT u FROM Player u WHERE u.team = :team")
    List<Player> findPlayersTeam(@Param("team") Team team);
}