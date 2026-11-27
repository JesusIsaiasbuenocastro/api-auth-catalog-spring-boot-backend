package com.norinti.spring.app.catalogo.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;


@RestController 
@RequestMapping("/api/v1/catalog")
public class CatalogController {


    @GetMapping
    public String getMethodName(@RequestParam String param) {
        return new String();
    }
    

}
