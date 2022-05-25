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

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getBirthDate() {
        return birhtDate;
    }

    public void setBirthDate(String birthDate) {
        this.birhtDate = birthDate;
    }

    public int getTeam() {
        return team;
    }

    public void setTeam(int team) {
        this.team = team;
    }
}
