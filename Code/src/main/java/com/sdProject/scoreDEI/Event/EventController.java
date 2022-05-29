package com.sdProject.scoreDEI.Event;

import org.springframework.stereotype.Controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.ui.Model;


@Controller
public class EventController {

    @Autowired
    EventService eventService;

    @GetMapping("event1")
    public String event1(Model model) {
        return "event1";
    }

    @PostMapping("event1")
    public String event1(@RequestParam(name = "id", required = true) int id, Model model) {
        return "event1";
    }
    
    @GetMapping("event2")
    public String event2(Model model) {
        return "event2";
    }

    @GetMapping("event3")
    public String event3(Model model) {
        return "event3";
    }

    @GetMapping("event4")
    public String event4(Model model) {
        return "event4";
    }

    @GetMapping("event5")
    public String event5(Model model) {
        return "event5";
    }

    @GetMapping("event6")
    public String event6(Model model) {
        return "event6";
    }
}
