package com.sdProject.scoreDEI.Person;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.ui.Model;

@Controller
public class PersonController {
    @Autowired
    PersonService personService;

    @GetMapping("/")
    public String redirect() {
        return "redirect:/login";
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

    @PostMapping("/saveUser")
    public String saveUser(@ModelAttribute Person person, Model model) {
        model.addAttribute("person", person);
        this.personService.addPerson(person);
        return "redirect:/login";
    }
}
