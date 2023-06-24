package com.ziimme.websource.models;

import javax.persistence.criteria.Predicate;

import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Component;

@Component
public class PositionSpecification {
    public Specification<Position> searchByName(String q) {
        return (root, query, cb) -> {
            Predicate nameTh = cb.like(
                    root.get("positionNameTh"),
                    "%" + q + "%");

            Predicate nameEn = cb.like(
                    root.get("positionNameEng"),
                    "%" + q + "%");

            return cb.or(nameTh, nameEn);
        };
    }

    public Specification<Position> byActiveStatus() {
        return (root, query, cb) -> cb.equal(
                root.get("recordStatus"),
                "A");
    }

    public Specification<Position> search(String q) {
        Specification specification;

        specification = Specification.where(byActiveStatus());
        if (q != null && !q.isEmpty()) {
            specification = specification.and(searchByName(q));
        }

        return specification;
    }
}
