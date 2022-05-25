package com.sdProject.scoreDEI.Game;

import org.springframework.stereotype.Controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.ui.Model;

@Controller
public class GameController {
    @Autowired
    GameService gameService;

    @GetMapping("/createGame")
    public String createUser(Model model) {
        model.addAttribute("game", new Game());
        return "addGame";
    }

    @PostMapping("/saveGame")
    public String saveUser(@ModelAttribute Game game, Model model) {
        model.addAttribute("game", game);
        this.gameService.addGame(game);
        return "redirect:/homepage";
    }
}
