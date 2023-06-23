package com.ziimme.websource.models;

import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Component;

@Component
public class EmployeeSpecification {
    public Specification<Employee> searchByName(String q) {
        return (root, query, cb) -> cb.like(
                root.get("empFullname"),
                "%" + q + "%");
    }

    public Specification<Employee> byActiveStatus() {
        return (root, query, cb) -> cb.equal(
                root.get("recordStatus"),
                "A");
    }

    public Specification<Employee> byUseStatus(String useStatus) {
        return (root, query, cb) -> cb.equal(
                root.get("rec"),
                useStatus);
    }

    public Specification<Employee> search(String q, String useStatus, int type) {
        Specification specification;

        specification = Specification.where(byActiveStatus());

        if (q != null && !q.isEmpty()) {
            specification = specification.and(searchByName(q));
        }

        if (useStatus != null && !useStatus.isEmpty()) {
            specification = specification.and(byUseStatus(useStatus));
        }

        return specification;
    }
}
