package com.ziimme.websource.models;

import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Component;
import javax.persistence.criteria.Predicate;

@Component
public class EmployeeSpecification {
    public Specification<Employee> searchByName(String q) {
        return (root, query, cb) -> {
            Predicate nameFull = cb.like(
                    root.get("empFullname"),
                    "%" + q + "%");

            Predicate nameNick = cb.like(
                    root.get("empNickname"),
                    "%" + q + "%");

            return cb.or(nameFull, nameNick);
        };
    }

    public Specification<Employee> byActiveStatus() {
        return (root, query, cb) -> cb.equal(
                root.get("recordStatus"),
                "A");
    }

    public Specification<Employee> search(String q) {
        Specification specification;

        specification = Specification.where(byActiveStatus());
        if (q != null && !q.isEmpty()) {
            specification = specification.and(searchByName(q));
        }

        return specification;
    }
}
