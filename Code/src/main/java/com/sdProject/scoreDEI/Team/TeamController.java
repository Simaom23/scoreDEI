package com.sdProject.scoreDEI.Team;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
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

    @GetMapping("/manageTeam")
    public String managePlayer(@RequestParam(name = "id", required = true) int id, Model model) {
        Optional<Team> op = this.teamService.getTeam(id);
        if (op.isPresent()) {
            model.addAttribute("team", op.get());
            return "manageTeam";
        } else {
            return "redirect:/listTeams";
        }
    }

    @PostMapping("/saveTeam")
    public String saveTeam(@ModelAttribute Team team, Model model) {
        model.addAttribute("team", team);
        this.teamService.addTeam(team);
        return "redirect:/listTeams";
    }

    @PostMapping("/deleteTeam")
    public String deleteTeam(@ModelAttribute Team team) {
        this.teamService.deleteTeam(team);
        return "redirect:/listTeams";
    }

    @GetMapping("/listTeams")
    public String listPlayer(Model model) {
        model.addAttribute("teams", this.teamService.getAllTeams());
        return "listTeams";
    }
}
