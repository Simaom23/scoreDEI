package com.sdProject.scoreDEI.Game;

import com.sdProject.scoreDEI.Team.Team;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface GameRepository extends CrudRepository<Game, Integer> {
    @Query("SELECT COUNT(e) FROM Event e WHERE e.team = :team AND e.eventType = 'Goal'")
    int getGameGoals(@Param("team") Team team);
}
