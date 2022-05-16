package com.sdProject.scoreDEI.Player;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Player {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String name, position, birhtDate;
    private int team;

    public Player() {
    }

    public Player(String name, String position, String birthDate, int team) {
        this.name = name;
        this.position = position;
        this.birhtDate = birthDate;
        this.team = team;
    }
}
