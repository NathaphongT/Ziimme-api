package com.ziimme.websource.models;

import javax.persistence.criteria.Predicate;

import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Component;

@Component
public class CourseSpecification {
    public Specification<Course> searchByName(String q) {
        return (root, query, cb) -> {
            Predicate nameTh = cb.like(
                    root.get("courseNameTh"),
                    "%" + q + "%");

            Predicate nameEn = cb.like(
                    root.get("courseNameEng"),
                    "%" + q + "%");

            return cb.or(nameTh, nameEn);
        };
    }

    public Specification<Course> byActiveStatus() {
        return (root, query, cb) -> cb.equal(
                root.get("recordStatus"),
                "A");
    }

    public Specification<Course> search(String q) {
        Specification specification;

        specification = Specification.where(byActiveStatus());
        if (q != null && !q.isEmpty()) {
            specification = specification.and(searchByName(q));
        }

        return specification;
    }
}
