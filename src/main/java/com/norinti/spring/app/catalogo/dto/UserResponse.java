package com.norinti.spring.app.catalogo.dto;

public record UserResponse(String username, String role, String tenant, boolean enabled ) {

}
