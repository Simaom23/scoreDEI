package com.sdProject.scoreDEI.Game;

import org.springframework.stereotype.Controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.ui.Model;
import com.sdProject.scoreDEI.Team.TeamService;

@Controller
public class GameController {
    @Autowired
    GameService gameService;

    @Autowired
    TeamService teamService;

    @GetMapping("/createGame")
    public String createTeam(Model model) {
        model.addAttribute("game", new Game());
        model.addAttribute("allTeams", this.teamService.getAllTeams());
        return "createGame";
    }

    @PostMapping("/saveGame")
    public String saveTeam(@ModelAttribute Game game, Model model) {
        model.addAttribute("game", game);
        this.gameService.addGame(game);
        return "redirect:/homepage";
    }

    @GetMapping("/listGames")
    public String listPlayer(Model model) {
        model.addAttribute("games", this.gameService.getAllGames());
        return "listGames";
    }
}
