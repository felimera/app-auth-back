package com.proyecto.appauth.repository;

import com.proyecto.appauth.model.AccessPermits;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AccessPermitsRepository extends JpaRepository<AccessPermits, Integer>, AccessPermitsCriteriaRepository {
}
