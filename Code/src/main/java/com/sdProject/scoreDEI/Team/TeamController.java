package com.sdProject.scoreDEI.Team;

import java.util.Optional;

import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.ui.Model;

import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.JsonNode;
import com.mashape.unirest.http.Unirest;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;

@Controller
public class TeamController {
    @Autowired
    TeamService teamService;

    @GetMapping("/loadTeams")
    public String loadTeams(Model model) throws Exception{
        
        Unirest.setTimeouts(0, 0);
        String host = "https://v3.football.api-sports.io/";
        String query = "/teams?league=2&season=2021";

        HttpResponse<JsonNode> response = Unirest.get(host + query)
        .header("x-rapidapi-key", "b43ff12ff9935aac041a44e7554f52be")
        .header("x-rapidapi-host", "v3.football.api-sports.io")
        .asJson();
        
        // Gson gson = new GsonBuilder().setPrettyPrinting().create();
        // JsonParser jp = new JsonParser();
        // JsonElement je = jp.parse(response.getBody().toString());
        // String prettyJsonString = gson.toJson(je);
        // System.out.println("status\n" + response.getStatus() + "\n");
        // System.out.println("pretty\n" + prettyJsonString + "\n");

        JSONArray jo = (JSONArray) response.getBody().getObject().get("response");
        for (int i = 0; i < jo.length(); i++) {
            //System.out.println(jo.get(i));
        
            JSONObject object = (JSONObject) jo.get(i);
            //JSONObject venue = (JSONObject) object.get("venue");
            JSONObject team = (JSONObject) object.get("team");

            Team t = new Team(team.getString("name"));
            this.teamService.addTeam(t);
        }

        return "redirect:/listTeams";
    }

    @GetMapping("/createTeam")
    public String createTeam(Model model) {
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
