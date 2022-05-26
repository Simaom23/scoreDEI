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
    public String createTeam(Model model) {
        Team[] teams = {
                new Team("Sporting CP"),
                new Team("SL Benfica"),
                new Team("FC Porto")
        };
        for (Team team : teams)
            this.teamService.addTeam(team);
        model.addAttribute("team", new Team());
        return "createTeam";
    }

    @PostMapping("/saveTeam")
    public String saveTeam(@ModelAttribute Team team, Model model) {
        model.addAttribute("team", team);
        this.teamService.addTeam(team);
        return "redirect:/homepage";
    }

    @GetMapping("/listTeams")
    public String listPlayer(Model model) {
        model.addAttribute("teams", this.teamService.getAllTeams());
        return "listTeams";
    }
}
