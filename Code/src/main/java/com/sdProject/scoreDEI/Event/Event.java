package com.sdProject.scoreDEI.Event;

import java.sql.Date;
import java.sql.Time;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import com.sdProject.scoreDEI.Game.Game;
import com.sdProject.scoreDEI.Player.Player;
import com.sdProject.scoreDEI.Team.Team;

@Entity
public class Event {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    @ManyToOne
    private Game game;
    @ManyToOne
    private Team team;
    @ManyToOne
    private Player player;
    private String event;
    private Date date;
    private Time time;

    public Event() {
    }

    public Event(Game game, Team team, Player player, String event, Date date, Time time) {
        this.game = game;
        this.team = team;
        this.player = player;
        this.event = event;
        this.date = date;
        this.time = time;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Game getGame() {
        return game;
    }

    public void setGame(Game game) {
        this.game = game;
    }

    public Team getTeam() {
        return team;
    }

    public void setTeam(Team team) {
        this.team = team;
    }

    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }

    public String setEvent() {
        return event;
    }

    public void setEvent(String event) {
        this.event = event;
    }

    public Date setDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Time setTime() {
        return time;
    }

    public void setTime(Time time) {
        this.time = time;
    }

}
