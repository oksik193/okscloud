package org.oksik193.okscloud.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class GreetingController {

    @GetMapping("/")
    public String home (Model model) { return "greeting"; }

    @GetMapping("/about")
    public String about(Model model) {
        return "about";
    }

}