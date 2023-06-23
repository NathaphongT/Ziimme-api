package com.ziimme.websource.models;

import org.springframework.data.jpa.domain.Specification;

import javax.persistence.criteria.Predicate;

public class CustomerSpecification {
    public Specification<Customer> searchByName(String q) {
        return (root, query, cb) -> {
            Predicate nameTh = cb.like(
                    root.get("cus_member"),
                    "%" + q + "%");

            Predicate nameEn = cb.like(
                    root.get("cus_full_name"),
                    "%" + q + "%");

            return cb.or(nameTh, nameEn);
        };
    }

    public Specification<Customer> byActiveStatus() {
        return (root, query, cb) -> cb.equal(
                root.get("recordStatus"),
                "A");
    }

    public Specification<Customer> search(String q) {
        Specification specification;

        specification = Specification.where(byActiveStatus());
        if (q != null && !q.isEmpty()) {
            specification = specification.and(searchByName(q));
        }

        return specification;
    }
}
