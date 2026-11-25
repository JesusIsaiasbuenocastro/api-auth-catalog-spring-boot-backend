package com.norinti.spring.app.catalogo.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.norinti.spring.app.catalogo.domain.User;
import com.norinti.spring.app.catalogo.dto.CreateUserRequest;
import com.norinti.spring.app.catalogo.dto.CreateUserResponse;
import com.norinti.spring.app.catalogo.mappers.UserMapper;
import com.norinti.spring.app.catalogo.service.UserService;

import jakarta.validation.Valid;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController 
@RequestMapping("/api/auth")
public class UserController {

    private final UserService userService;

    public UserController (UserService userService){
        this.userService = userService;
    }

    @GetMapping
    public String getTest() {
        return  "Hola mundo";
    }

    @PostMapping("/register")
    public ResponseEntity<CreateUserResponse> register(@Valid @RequestBody CreateUserRequest request) {
        User user  = userService.save(UserMapper.requestToDomainMapper(request,"1" ));
        return ResponseEntity.status(HttpStatus.CREATED).body(UserMapper.domainToResponseMapper(user));
    }

}
