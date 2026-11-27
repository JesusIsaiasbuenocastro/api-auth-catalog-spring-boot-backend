package com.norinti.spring.app.catalogo.dto;

public record LoginResponse(    
    String token,
    String tokenType,
    long expiresInSeconds) {

}
