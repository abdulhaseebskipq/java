package com.telusko.ecomApp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.telusko.ecomApp.service.homeService;

@CrossOrigin
@RestController
public class HomeController {


    @Autowired
    private homeService hService;

    @GetMapping("/")
    public String greet(){
        return hService.greet();
    }
    
}
