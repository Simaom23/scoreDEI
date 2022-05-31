package com.sdProject.scoreDEI.Event;

import org.springframework.stereotype.Controller;

import java.util.Optional;

import com.sdProject.scoreDEI.Game.Game;
import com.sdProject.scoreDEI.Game.GameService;
import com.sdProject.scoreDEI.Team.Team;
import com.sdProject.scoreDEI.Team.TeamService;
import com.sdProject.scoreDEI.Player.PlayerService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.ui.Model;

@Controller
public class EventController {

    @Autowired
    EventService eventService;

    @Autowired
    GameService gameService;

    @Autowired
    PlayerService playerService;

    @Autowired
    TeamService teamService;

    @GetMapping("/registerEvent")
    public String registerEvent(@RequestParam(name = "id", required = true) int id,
            @RequestParam(name = "eventType", required = true) String eventType, Model model) {
        Optional<Game> op = this.gameService.getGame(id);
        if (op.isPresent()) {
            model.addAttribute("event", new Event());
            model.addAttribute("game", op.get());
            model.addAttribute("eventType", eventType);

            if (eventType.equals("Game Started")) {
                if (op.get().getStarted() == false) {
                    op.get().setStarted(true);
                    return "registerOtherEvent";
                }
                return "redirect:/gameStats?id=" + id;

            } else if (eventType.equals("Game Ended")) {
                if (op.get().getEnded() == false) {
                    op.get().setEnded(true);
                    return "registerOtherEvent";
                }
                return "redirect:/gameStats?id=" + id;

            } else if (eventType.equals("Game Interrupted")) {
                if (op.get().getInterrupted() == false) {
                    op.get().setInterrupted(true);
                    return "registerOtherEvent";
                }
                return "redirect:/gameStats?id=" + id;

            } else if (eventType.equals("Game Resumed")) {
                if (op.get().getInterrupted() == true) {
                    op.get().setInterrupted(false);
                    return "registerOtherEvent";
                }
                return "redirect:/gameStats?id=" + id;

            } else
                return "registerEvent";

        } else
            return "redirect:/gameStats?id=" + id;
    }

    @GetMapping("/registerEventUser")
    public String registerEventUser(@RequestParam(name = "id", required = true) int id,
            @RequestParam(name = "eventType", required = true) String eventType, Model model) {
        Optional<Game> op = this.gameService.getGame(id);
        if (op.isPresent()) {
            model.addAttribute("event", new Event());
            model.addAttribute("game", op.get());
            model.addAttribute("eventType", eventType);

            if (eventType.equals("Game Started")) {
                if (op.get().getStarted() == false) {
                    op.get().setStarted(true);
                    return "registerOtherEventUser";
                }
                return "redirect:/gameStatsUser?id=" + id;

            } else if (eventType.equals("Game Ended")) {
                if (op.get().getEnded() == false) {
                    op.get().setEnded(true);
                    return "registerOtherEventUser";
                }
                return "redirect:/gameStatsUser?id=" + id;

            } else if (eventType.equals("Game Interrupted")) {
                if (op.get().getInterrupted() == false) {
                    op.get().setInterrupted(true);
                    return "registerOtherEventUser";
                }
                return "redirect:/gameStatsUser?id=" + id;

            } else if (eventType.equals("Game Resumed")) {
                if (op.get().getInterrupted() == true) {
                    op.get().setInterrupted(false);
                    return "registerOtherEventUser";
                }
                return "redirect:/gameStatsUser?id=" + id;

            } else
                return "registerEventUser";

        } else
            return "redirect:/gameStatsUser?id=" + id;
    }

    @PostMapping("/saveEvent")
    public String saveEvent(@ModelAttribute Event event) {
        if (event.getEventType().equals("Goal")) {
            this.playerService.addGoal(event.getPlayer().getId());
        } else if (event.getEventType().equals("Game Ended")) {
            Team homeTeam = event.getGame().getHomeTeam();
            Team awayTeam = event.getGame().getAwayTeam();
            this.teamService.addGames(homeTeam.getId());
            this.teamService.addGames(awayTeam.getId());
            int homeGoals = this.gameService.getTeamGoals(homeTeam);
            int awayGoals = this.gameService.getTeamGoals(awayTeam);
            if (homeGoals > awayGoals) {
                this.teamService.addWins(homeTeam.getId());
                this.teamService.addLosses(awayTeam.getId());
            } else if (homeGoals < awayGoals) {
                this.teamService.addLosses(homeTeam.getId());
                this.teamService.addWins(awayTeam.getId());
            } else {
                this.teamService.addDefeats(homeTeam.getId());
                this.teamService.addDefeats(awayTeam.getId());
            }
        }
        this.eventService.addEvent(event);

        return "redirect:/gameStats?id=" + event.getGame().getId();
    }

    @PostMapping("/saveEventUser")
    public String saveEventUser(@ModelAttribute Event event) {
        if (event.getEventType().equals("Goal")) {
            this.playerService.addGoal(event.getPlayer().getId());
        } else if (event.getEventType().equals("Game Ended")) {
            Team homeTeam = event.getGame().getHomeTeam();
            Team awayTeam = event.getGame().getAwayTeam();
            this.teamService.addGames(homeTeam.getId());
            this.teamService.addGames(awayTeam.getId());
            int homeGoals = this.gameService.getTeamGoals(homeTeam);
            int awayGoals = this.gameService.getTeamGoals(awayTeam);
            if (homeGoals > awayGoals) {
                this.teamService.addWins(homeTeam.getId());
                this.teamService.addLosses(awayTeam.getId());
            } else if (homeGoals < awayGoals) {
                this.teamService.addLosses(homeTeam.getId());
                this.teamService.addWins(awayTeam.getId());
            } else {
                this.teamService.addDefeats(homeTeam.getId());
                this.teamService.addDefeats(awayTeam.getId());
            }
        }
        this.eventService.addEvent(event);

        return "redirect:/gameStatsUser?id=" + event.getGame().getId();
    }
}
