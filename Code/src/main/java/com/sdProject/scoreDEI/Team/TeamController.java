package com.sdProject.scoreDEI.Team;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.ui.Model;

@Controller
public class TeamController {
    @Autowired
    TeamService teamService;

    @GetMapping("/createTeam")
    public String createUser(Model model) {
        Team[] teams = {
                new Team("José"),
                new Team("Paulo"),
                new Team("Estrela")
        };
        for (Team team : teams)
            this.teamService.addTeam(team);
        model.addAttribute("user", new Team());
        return "addTeam";
    }

    @PostMapping("/saveTeam")
    public String saveUser(@ModelAttribute Team team, Model model) {
        model.addAttribute("team", team);
        this.teamService.addTeam(team);
        return "redirect:/homepage";
    }
}
