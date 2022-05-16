package com.sdProject.scoreDEI.Game;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Game {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String homeTeam, awayTeam, location, date;

    public Game() {
    }

    public Game(String homeTeam, String awayTeam, String location, String date) {
        this.homeTeam = homeTeam;
        this.awayTeam = awayTeam;
        this.location = location;
        this.date = date;
    }
}
