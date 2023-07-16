package com.ziimme.websource.models;

import javax.persistence.criteria.Predicate;

import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Component;

@Component
public class SaleSpecification {
    public Specification<Sale> searchByName(String q) {
        return (root, query, cb) -> cb.like(
                root.get("saleProduct"),
                "%" + q + "%");
    }

    public Specification<Sale> searchBySaleId(int type) {
        return (root, query, cb) -> cb.equal(
                root.get("saleId"),
                type);
    }

    public Specification<Sale> byActiveStatus() {
        return (root, query, cb) -> cb.equal(
                root.get("recordStatus"),
                "A");
    }

    public Specification<Sale> search(String q, int type) {
        Specification specification;

        specification = Specification.where(byActiveStatus());

        if (q != null && !q.isEmpty()) {
            specification = specification.and(searchByName(q));
        }

        if (type != 0) {
            specification = specification.and(searchBySaleId(type));
        }

        return specification;
    }
}
