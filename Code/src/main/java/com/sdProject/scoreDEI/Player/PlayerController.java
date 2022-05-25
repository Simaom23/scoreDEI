package com.sdProject.scoreDEI.Player;

import org.springframework.stereotype.Controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.ui.Model;

@Controller
public class PlayerController {
    @Autowired
    PlayerService playerService;

    @GetMapping("/createPlayer")
    public String createUser(Model model) {
        model.addAttribute("player", new Player());
        return "addPlayer";
    }

    @PostMapping("/savePlayer")
    public String saveUser(@ModelAttribute Player player, Model model) {
        model.addAttribute("player", player);
        this.playerService.addUser(player);
        return "redirect:/homepage";
    }
}
