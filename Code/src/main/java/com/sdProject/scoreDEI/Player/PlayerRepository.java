package com.sdProject.scoreDEI.Player;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface PlayerRepository extends CrudRepository<Player, Integer> {
    @Query("SELECT u FROM Player u WHERE u.team = :id")
    List<Player> findPlayersTeam(@Param("id") Integer id);
}