package com.sdProject.scoreDEI.Player;

import org.springframework.stereotype.Controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.ui.Model;
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

    @PostMapping("/savePlayer")
    public String savePlayer(@ModelAttribute Player player, Model model) {
        model.addAttribute("player", player);
        this.playerService.addPlayer(player);
        return "redirect:/homepage";
    }

    @GetMapping("/listPlayers")
    public String listPlayer(Model model) {
        model.addAttribute("players", this.playerService.getAllPlayers());
        return "listPlayers";
    }
}
