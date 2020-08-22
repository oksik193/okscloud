package org.oksik193.okscloud.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class DiskController {

    @GetMapping("/disk")
    public String diskMain (Model model) {
        return "disk";
    }

}
