package com.proyecto.appauth.repository;

import com.proyecto.appauth.model.auth.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends CrudRepository<User, Integer> {

    Optional<User> findOneByEmail(String email);
}
