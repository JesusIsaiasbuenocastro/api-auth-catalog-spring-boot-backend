package com.norinti.spring.app.catalogo.service;

import java.util.List;

import com.norinti.spring.app.catalogo.domain.User;

public interface UserService {
    record AuthToken(String token, String tokenType, long expireInSeconds){}
    public User save(User user); 
    public List<User> findAll(); 
    
    public AuthToken login(User user); 
}
