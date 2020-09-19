package com.goudscode.controller;

import org.springframework.web.bind.annotation.*;

@RestController
public class Controller {

    @GetMapping("/hi")
    public String hello_world(){
        return "Don't Know...!!!";
    }
    @GetMapping("/name")
    public String temp(){
        return "Sainath";
    }

}
