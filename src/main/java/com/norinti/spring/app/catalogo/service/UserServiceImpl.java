package com.norinti.spring.app.catalogo.service;

import java.util.List;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.norinti.spring.app.catalogo.domain.User;
import com.norinti.spring.app.catalogo.repository.UserRepository;

@Service 
public class UserServiceImpl implements UserService{

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public UserServiceImpl(UserRepository userRepository, PasswordEncoder passwordEncoder){
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    @Transactional 
    public User save(User user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
       return userRepository.save(user);
    }

    @Override
    @Transactional 
    public List<User> findAll() {
         return userRepository.findAll();
    }

}
