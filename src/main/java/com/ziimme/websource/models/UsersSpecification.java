package com.ziimme.websource.models;

import javax.persistence.criteria.Predicate;

import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Component;

@Component
public class UsersSpecification {
    public Specification<Users> searchByName(String q) {
        return (root, query, cb) -> cb.like(
                root.get("displayName"),
                "%" + q + "%");
    }

    public Specification<Users> byActiveStatus() {
        return (root, query, cb) -> cb.equal(
                root.get("recordStatus"),
                "A");
    }

    public Specification<Users> search(String q) {
        Specification specification;

        specification = Specification.where(byActiveStatus());
        if (q != null && !q.isEmpty()) {
            specification = specification.and(searchByName(q));
        }

        return specification;
    }
}
