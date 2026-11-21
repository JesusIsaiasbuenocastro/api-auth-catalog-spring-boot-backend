package com.norinti.spring.app.catalogo.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController 
@RequestMapping("/api/auth")
public class LoginController {


    @GetMapping
    public String getTest() {
        return  "Hola mundo";
    }
    

}
