package com.proyecto.appauth.repository;

import com.proyecto.appauth.model.RouterLink;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RouterLinkRepository extends JpaRepository<RouterLink, Long> {
}
