package com.wanfadger.QueryCriteria.specification;

import com.wanfadger.QueryCriteria.entity.Project;
import org.springframework.data.jpa.domain.Specification;

import java.time.LocalDateTime;

public class ProjectionSpecification {
    public static Specification<Project> isProjectNameLike(String likePattern) {
        return (root, query, builder) -> builder.like(root.get("name"), likePattern);
    }

}
