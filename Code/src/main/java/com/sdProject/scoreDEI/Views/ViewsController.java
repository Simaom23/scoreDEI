package com.sdProject.scoreDEI.Views;

import java.util.Optional;

import com.sdProject.scoreDEI.Game.Game;
import com.sdProject.scoreDEI.Game.GameService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ViewsController {
    @Autowired
    GameService gameService;

    @GetMapping("/homepage")
    public String homepageAdmin(Model model) {
        model.addAttribute("games", this.gameService.getAllGames());
        return "homepage";
    }

    @GetMapping("/homepageUser")
    public String homepageUser(Model model) {
        model.addAttribute("games", this.gameService.getAllGames());
        return "homepageUser";
    }

    @GetMapping("/homepageUnsigned")
    public String homepageUnsigned(Model model) {
        model.addAttribute("games", this.gameService.getAllGames());
        return "homepageUnsigned";
    }

    @GetMapping("/gameStats")
    public String gameStats(@RequestParam(name = "id", required = true) int id, Model model) {
        Optional<Game> op = this.gameService.getGameById(id);
        if (op.isPresent()) {
            Game game = op.get();
            model.addAttribute("game", game);
            model.addAttribute("homeGoals", this.gameService.getTeamGoals(game.getHomeTeam()));
            model.addAttribute("awayGoals", this.gameService.getTeamGoals(game.getAwayTeam()));
            return "gameStats";
        } else {
            return "redirect:/homepage";
        }
    }

    @GetMapping("/gameStatsUser")
    public String gameStatsUser(@RequestParam(name = "id", required = true) int id, Model model) {
        Optional<Game> op = this.gameService.getGameById(id);
        if (op.isPresent()) {
            Game game = op.get();
            model.addAttribute("game", game);
            model.addAttribute("homeGoals", this.gameService.getTeamGoals(game.getHomeTeam()));
            model.addAttribute("awayGoals", this.gameService.getTeamGoals(game.getAwayTeam()));
            return "gameStatsUser";
        } else {
            return "redirect:/homepageUser";
        }
    }

    @GetMapping("/gameStatsUnsigned")
    public String gameStatsUnsigned(@RequestParam(name = "id", required = true) int id, Model model) {
        Optional<Game> op = this.gameService.getGameById(id);
        if (op.isPresent()) {
            Game game = op.get();
            model.addAttribute("game", game);
            model.addAttribute("homeGoals", this.gameService.getTeamGoals(game.getHomeTeam()));
            model.addAttribute("awayGoals", this.gameService.getTeamGoals(game.getAwayTeam()));
            return "gameStatsUnsigned";
        } else {
            return "redirect:/homepageUnsigned";
        }
    }

}
