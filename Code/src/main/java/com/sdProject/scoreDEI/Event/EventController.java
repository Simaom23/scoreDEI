package com.sdProject.scoreDEI.Event;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class EventController {

    @Autowired
    EventService eventService;
    
    @GetMapping("/event") 
    public String event(Model model){
        return "event";
    }
}
