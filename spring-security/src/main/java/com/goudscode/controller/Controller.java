package com.goudscode.controller;

import org.springframework.web.bind.annotation.*;

@RestController
public class Controller {

    @GetMapping("/admin/api/v1")
    public String admin(){
        return "This is Admin API...!!!";
    }
    @GetMapping("/student/api/v1")
    public String student(){
        return "This is Student API...!!!";
    }

}
