package com.norinti.spring.app.catalogo.dto;

import java.time.LocalDateTime;

public record CreateUserResponse(String username,
    String rol, 
    LocalDateTime datetime
) {}
