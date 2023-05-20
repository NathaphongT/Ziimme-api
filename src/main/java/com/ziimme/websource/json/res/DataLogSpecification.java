package com.ziimme.websource.json.res;

import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Component;

import com.ziimme.websource.models.DataLogs;

import javax.persistence.criteria.Predicate;

@Component
public class DataLogSpecification {
    public Specification<DataLogs> searchByName(String q) {
        return (root, query, cb) -> {
            Predicate logMenu = cb.like(
                    root.get("logMenu"),
                    "%"+ q + "%"
            );

            Predicate logTitle = cb.like(
                    root.get("logTitle"),
                    "%"+ q + "%"
            );

            Predicate logActivity = cb.like(
                    root.get("logActivity"),
                    "%"+ q + "%"
            );

            Predicate logUserName = cb.like(
                    root.get("logUserName"),
                    "%"+ q + "%"
            );

            return cb.or(logMenu, logTitle, logActivity, logUserName);
        };
    }

    public Specification<DataLogs> byActiveStatus() {
        return (root, query, cb) ->
                cb.equal(
                        root.get("recordStatus"),
                        "A"
                );
    }

    public Specification<DataLogs> search(String q) {
        Specification specification;

        specification = Specification.where(byActiveStatus());
        if (q != null && !q.isEmpty()) {
            specification = specification.and(searchByName(q));
        }

        return specification;
    }
}
