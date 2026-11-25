package com.norinti.spring.app.catalogo.mappers;

import java.time.LocalDateTime;

import com.norinti.spring.app.catalogo.domain.User;
import com.norinti.spring.app.catalogo.dto.CreateUserRequest;
import com.norinti.spring.app.catalogo.dto.CreateUserResponse;
import com.norinti.spring.app.catalogo.entities.UserEntity;

public class UserMapper {

    public static User requestToDomainMapper (CreateUserRequest userRequest, String tenant){
        return  new User(userRequest.username(), 
                            userRequest.password(),
                            tenant, 
                            userRequest.role());

    }

    public static CreateUserResponse domainToResponseMapper (User user ){
        return  new CreateUserResponse(user.getUsername(), 
                            user.getRole(),
                        LocalDateTime.now());

    }

    public static User entityToUser (UserEntity userEntity ){
        return new User(userEntity.getUsername(), 
                userEntity.getPassword(),
                userEntity.getTenant(),
                userEntity.getRole());
    }

    public static UserEntity userToEntity (User user ){
        return new UserEntity(user.getUsername(), 
                user.getPassword(),
                user.getTenant(),
                user.getRole());
    }

}
