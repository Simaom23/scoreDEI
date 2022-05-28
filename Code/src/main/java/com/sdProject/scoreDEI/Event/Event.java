package com.sdProject.scoreDEI.Event;

import java.sql.Date;
import java.sql.Time;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import com.sdProject.scoreDEI.Game.Game;
import com.sdProject.scoreDEI.Person.Person;
import com.sdProject.scoreDEI.Player.Player;

@Entity
public class Event {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    @ManyToOne
    private Game game;
    @ManyToOne
    private Player player;
    private int type;
    String text;
    Date date;
    Time time;

    public Event() {
    }

    public Event(Game game, Player player, int type, String text, Date date, Time time) {
        this.game = game;
        this.player = player;
        this.type = type;
        this.text = text;
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

    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

}
