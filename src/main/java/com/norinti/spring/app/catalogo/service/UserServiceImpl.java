package com.norinti.spring.app.catalogo.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.norinti.spring.app.catalogo.domain.User;
import com.norinti.spring.app.catalogo.repository.UserRepository;

@Service 
public class UserServiceImpl implements UserService{

    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository){
        this.userRepository = userRepository;
    }

    @Override
    @Transactional 
    public User save(User user) {
       return userRepository.save(user);
    }

    @Override
    @Transactional 
    public List<User> findAll() {
         return userRepository.findAll();
    }

}
