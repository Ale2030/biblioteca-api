package com.alexis.proyecto.biblioteca_api.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    @GetMapping("/index")
    public String showIndexPage() {
        return "index";
    }

}
