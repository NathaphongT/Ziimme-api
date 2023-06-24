package com.ziimme.websource.models;

import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Component;

@Component
public class SaleSpecification {
    public Specification<Sale> searchByName(String q) {
        return (root, query, cb) -> cb.like(
                root.get("saleNumber"),
                "%" + q + "%");
    }

    public Specification<Sale> byActiveStatus() {
        return (root, query, cb) -> cb.equal(
                root.get("recordStatus"),
                "A");
    }

    public Specification<Sale> search(String q, String useStatus, int type) {
        Specification specification;

        specification = Specification.where(byActiveStatus());

        if (q != null && !q.isEmpty()) {
            specification = specification.and(searchByName(q));
        }

        return specification;
    }
}
