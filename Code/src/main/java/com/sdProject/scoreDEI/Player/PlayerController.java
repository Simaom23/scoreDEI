package com.sdProject.scoreDEI.Player;

import org.springframework.stereotype.Controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.ui.Model;

import java.util.Optional;

import com.sdProject.scoreDEI.Team.TeamService;

@Controller
public class PlayerController {
    @Autowired
    PlayerService playerService;

    @Autowired
    TeamService teamService;

    @GetMapping("/createPlayer")
    public String createPlayer(Model model) {
        model.addAttribute("player", new Player());
        model.addAttribute("allTeams", this.teamService.getAllTeams());
        return "createPlayer";
    }

    @GetMapping("/managePlayer")
    public String managePlayer(@RequestParam(name = "id", required = true) int id, Model model) {
        Optional<Player> op = this.playerService.getPlayer(id);
        if (op.isPresent()) {
            model.addAttribute("player", op.get());
            model.addAttribute("allTeams", this.teamService.getAllTeams());
            return "managePlayer";
        } else {
            return "redirect:/listPlayers";
        }
    }

    @PostMapping("/savePlayer")
    public String savePlayer(@ModelAttribute Player player) {
        this.playerService.addPlayer(player);
        return "redirect:/listPlayers";
    }

    @PostMapping("/deletePlayer")
    public String deletePlayer(@ModelAttribute Player player) {
        this.playerService.deletePlayer(player);
        return "redirect:/listPlayers";
    }

    @GetMapping("/listPlayers")
    public String listPlayer(Model model) {
        model.addAttribute("players", this.playerService.getGoalsDescending());
        return "listPlayers";
    }
}
