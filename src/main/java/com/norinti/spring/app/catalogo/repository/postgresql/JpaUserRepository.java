package com.norinti.spring.app.catalogo.repository.postgresql;

import org.springframework.data.repository.CrudRepository;
import com.norinti.spring.app.catalogo.entities.UserEntity;

public interface JpaUserRepository  extends CrudRepository<UserEntity,Long>{

} 
