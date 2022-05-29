package com.sdProject.scoreDEI.Event;

import org.springframework.stereotype.Controller;

import java.util.Optional;

import com.sdProject.scoreDEI.Game.Game;
import com.sdProject.scoreDEI.Game.GameService;
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

    @GetMapping("/registerEvent")
    public String registerEvent(@RequestParam(name = "id", required = true) int id,
            @RequestParam(name = "eventType", required = true) String eventType, Model model) {
        Optional<Game> op = this.gameService.getGame(id);
        if (op.isPresent()) {
            Game game = op.get();
            model.addAttribute("game", game);
            model.addAttribute("event", eventType);
            model.addAttribute("awayTeamPlayers", this.playerService.getTeamPlayers(game.getHomeTeam().getId()));
            model.addAttribute("homeTeamPlayers", this.playerService.getTeamPlayers(game.getAwayTeam().getId()));
            return "registerEvent";
        } else {
            return "redirect:/gameStats?id=" + id;
        }
    }

    @PostMapping("saveEvent")
    public String saveEvent(@ModelAttribute Event event) {
        this.eventService.addEvent(event);
        return "redirect:/gameStats?id=" + event.getGame().getId();
    }
}
