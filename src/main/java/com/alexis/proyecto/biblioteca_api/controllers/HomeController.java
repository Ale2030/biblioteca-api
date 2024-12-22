package com.alexis.proyecto.biblioteca_api.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    @GetMapping("/")
    public String redirectToApiIndex() {
        return "redirect:/api/v1/index";
    }

    @GetMapping("/index")
    public String showIndexPage() {
        return "index";
    }

}
