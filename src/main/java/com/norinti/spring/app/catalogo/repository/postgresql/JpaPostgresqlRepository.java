package com.norinti.spring.app.catalogo.repository.postgresql;

import java.util.List;
import java.util.Optional;
import java.util.stream.StreamSupport;

import org.springframework.stereotype.Repository;

import com.norinti.spring.app.catalogo.domain.User;
import com.norinti.spring.app.catalogo.entities.UserEntity;
import com.norinti.spring.app.catalogo.mappers.UserMapper;
import com.norinti.spring.app.catalogo.repository.UserRepository;

@Repository 
public class JpaPostgresqlRepository implements  UserRepository{

    private final JpaUserRepository jpaUserRepository;

    public JpaPostgresqlRepository(JpaUserRepository jpaUserRepository){
        this.jpaUserRepository = jpaUserRepository;
    }

    public User save(User user) {
        return UserMapper.entityToUser(jpaUserRepository.save(UserMapper.userToEntity(user)));
        
    }

    public List<User> findAll() {
        Iterable<UserEntity> users = jpaUserRepository.findAll();

        return StreamSupport
                .stream(users.spliterator(), false)
                .map(userEntity -> new User(
                        userEntity.getUsername(),
                        userEntity.getPassword(),
                        userEntity.getTenant(),
                        userEntity.getRole(),
                        userEntity.isEnabled()
                ))
                .toList();
    }

    @Override
    public Optional<User> findByUsername(String username) { 
        return  jpaUserRepository.findByUsername(username).map(UserMapper::entityToUser);
    }
}
