package com.norinti.spring.app.catalogo.repository;

import java.util.List;

import com.norinti.spring.app.catalogo.domain.User;

public interface UserRepository {
    public User save(User user); 
    public List<User> findAll(); 
}
