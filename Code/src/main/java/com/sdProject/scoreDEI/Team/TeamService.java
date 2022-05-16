package com.sdProject.scoreDEI.Team;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TeamService {

    @Autowired
    private TeamRepository teamRepository;

    public void addUser(Team team) {
        teamRepository.save(team);
    }
}
