package com.ziimme.websource.models;

import javax.persistence.criteria.Predicate;

import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Component;

@Component
public class SaleSpecification {
    public Specification<Sale> searchByName(String q) {
        return (root, query, cb) -> {
            Predicate nameTh = cb.like(
                    root.get("saleNumber"),
                    "%" + q + "%");

            Predicate nameEn = cb.like(
                    root.get("saleProduct"),
                    "%" + q + "%");

            return cb.or(nameTh, nameEn);
        };
    }

    public Specification<Sale> byActiveStatus() {
        return (root, query, cb) -> cb.equal(
                root.get("recordStatus"),
                "A");
    }

    public Specification<Sale> search(String q) {
        Specification specification;

        specification = Specification.where(byActiveStatus());
        if (q != null && !q.isEmpty()) {
            specification = specification.and(searchByName(q));
        }

        return specification;
    }
}
