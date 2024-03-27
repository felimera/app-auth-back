package com.proyecto.appauth.repository;

import com.proyecto.appauth.model.RoleType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RoleTypeRepository extends JpaRepository<RoleType, Integer> {
    Optional<RoleType> findOneByAcronym(String acronym);
}
