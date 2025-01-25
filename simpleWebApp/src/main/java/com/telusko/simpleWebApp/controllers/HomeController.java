package com.telusko.simpleWebApp.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {
    @RequestMapping("/")
    public String home() {
        return "you are on the home page";
    }

    @RequestMapping("/about")
    public String about() {
        return "you are on the about page";
    }

}
