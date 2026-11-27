package com.norinti.spring.app.catalogo.service;


import java.util.Date;
import java.util.List;

import javax.crypto.SecretKey;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.norinti.spring.app.catalogo.domain.User;
import com.norinti.spring.app.catalogo.exeptions.InvalidCredentialsException;
import com.norinti.spring.app.catalogo.repository.UserRepository;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;

@Service 
public class UserServiceImpl implements UserService{

    private static final String ROLE_CLAIM = "role";


    @Value("${security.jwt.secret}")
    String base64Secret;

    @Value("${security.jwt.expiration-minutes}")
    long expirationMinutes;

    private final SecretKey secretKey;



    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public UserServiceImpl(UserRepository userRepository, PasswordEncoder passwordEncoder, 
                        @Value("${security.jwt.secret}") 
                        String base64Secret,
                        @Value("${security.jwt.expiration-minutes}") String expirationMinutes){
        
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
        this.secretKey = Keys.hmacShaKeyFor(Decoders.BASE64.decode(base64Secret));
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

    @Override
    @Transactional 
    public AuthToken login(User userLogin) {

        User user = userRepository.findByUsername(userLogin.getUsername()).orElseThrow(() -> 
                    new InvalidCredentialsException("Usuario o contraseña incorrectos."));

         if(!passwordEncoder.matches(userLogin.getPassword(), user.getPassword())){
            throw new InvalidCredentialsException("Usuario o contraseña incorrectos");
        }
         String token = generateToken(userLogin.getUsername(), userLogin.getRole());

        return new AuthToken(token, "Bearer ", expirationSeconds());
        
    }

    public String generateToken(String userName, String role) {
        Date now = new Date();
        Date expiresAt = new Date(now.getTime() + expirationSeconds() * 1000);

        return Jwts.builder()
                .subject(userName)
                .claim(ROLE_CLAIM, role)
                .issuedAt(now)
                .expiration(expiresAt)
                .signWith(secretKey)
                .compact();
    }

    public long expirationSeconds() {
        return expirationMinutes * 60;
    }

}
