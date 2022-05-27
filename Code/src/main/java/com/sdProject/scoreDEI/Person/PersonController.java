package com.sdProject.scoreDEI.Person;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.ui.Model;

@Controller
public class PersonController {
    @Autowired
    PersonService personService;

    @GetMapping("/")
    public String redirect() {
        return "redirect:/homepage";
    }

    @GetMapping("/login")
    public String login() {
        return "login";
    }

    @GetMapping("/homepage")
    public String homepage() {
        return "homepage";
    }

    @GetMapping("/createUser")
    public String createUser(Model model) {
        model.addAttribute("user", new Person());
        return "createUser";
    }

    @GetMapping("/manageUser")
    public String manageUser(@RequestParam(name = "id", required = true) int id, Model model) {
        Optional<Person> op = this.personService.getPerson(id);
        if (op.isPresent()) {
            model.addAttribute("user", op.get());
            return "manageUser";
        } else {
            return "redirect:/listUsers";
        }
    }

    @PostMapping("/saveUser")
    public String saveUser(@ModelAttribute Person person) {
        this.personService.addPerson(person);
        return "redirect:/listUsers";
    }

    @PostMapping("/deleteUser")
    public String deleteUser(@ModelAttribute Person person) {
        this.personService.deletePerson(person);
        return "redirect:/listUsers";
    }

    @GetMapping("/listUsers")
    public String listUser(Model model) {
        model.addAttribute("users", this.personService.getAllUsers());
        return "listUsers";
    }
}
