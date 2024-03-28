package com.proyecto.appauth.repository.implementation;

import com.proyecto.appauth.model.AccessPermits;
import com.proyecto.appauth.model.AccessPermits_;
import com.proyecto.appauth.model.RoleType;
import com.proyecto.appauth.model.RoleType_;
import com.proyecto.appauth.repository.AccessPermitsCriteriaRepository;
import com.proyecto.appauth.util.Constants;
import jakarta.persistence.EntityManager;
import jakarta.persistence.criteria.*;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class AccessPermitsCriteriaRepositoryImpl implements AccessPermitsCriteriaRepository {

    private EntityManager em;

    @Autowired
    public AccessPermitsCriteriaRepositoryImpl(EntityManager em) {
        this.em = em;
    }

    @Override
    public List<AccessPermits> getAccessPermitsByRoleType(String acronym) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<AccessPermits> cq = cb.createQuery(AccessPermits.class);

        Root<AccessPermits> accessPermitsRoot = cq.from(AccessPermits.class);
        List<Predicate> predicates = new ArrayList<>();
        Join<AccessPermits, RoleType> accessPermitsRoleTypeJoin = accessPermitsRoot.join(AccessPermits_.ROLE_TYPE, JoinType.INNER);

        if (Objects.nonNull(acronym)) {
            predicates.add(cb.equal(accessPermitsRoleTypeJoin.get(RoleType_.ACRONYM), acronym));
        } else {
            predicates.add(cb.equal(accessPermitsRoleTypeJoin.get(RoleType_.ACRONYM), Constants.I));
        }

        if (!predicates.isEmpty()) {
            cq.where(predicates.toArray(new Predicate[0]));
            return em.createQuery(cq).getResultList();
        }

        return new ArrayList<>();
    }
}
