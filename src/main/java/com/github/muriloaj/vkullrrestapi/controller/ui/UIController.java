package com.github.muriloaj.vkullrrestapi.controller.ui;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class UIController {

    @RequestMapping("/")
    public String view () {
        return "redirect:/swagger-ui.html";
    }

}
