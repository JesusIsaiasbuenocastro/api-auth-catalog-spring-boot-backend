package com.norinti.spring.app.catalogo.repository;

import java.util.List;
import java.util.Optional;

import com.norinti.spring.app.catalogo.domain.User;

public interface UserRepository {
    public User save(User user); 
    Optional<User> findByUsername(String username);
    public List<User> findAll(); 
}
