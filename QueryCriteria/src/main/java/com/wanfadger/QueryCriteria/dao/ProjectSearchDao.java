package com.wanfadger.QueryCriteria.dao;

import com.wanfadger.QueryCriteria.entity.TaskStatus;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import jakarta.persistence.TypedQuery;
import jakarta.persistence.criteria.*;
import lombok.*;

import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.stereotype.Repository;

import com.wanfadger.QueryCriteria.entity.Project;

@Repository
@Setter
@Getter
public class ProjectSearchDao {

    protected final EntityManager em;

    public ProjectSearchDao(EntityManager em) {
        this.em = em;
    }

    public List<Project> search(Map<String, String> queryParams) {

        String name = queryParams.get("name");

        // 1 create criteriaBuilder
        CriteriaBuilder cb = em.getCriteriaBuilder();
        // 2 create Query Builder
        CriteriaQuery<Project> cq = cb.createQuery(Project.class);

        // 3 Root Query select * from project
        Root<Project> root = cq.from(Project.class);



        // 5 create predicates
        Set<Predicate> predicates = new HashSet<>();
        if (name != null) {
            Predicate namePredicate = cb.equal(cb.upper(root.get("name")), name.toUpperCase());
            Predicate nameStartsPredicate = cb.like(cb.upper(root.get("name")), "%"+name.toUpperCase()+"%");

            predicates.add(namePredicate);
            predicates.add(nameStartsPredicate);

        }

        // 5 added predicates to where
        cq.select(root).where(cb.or(predicates.toArray(new Predicate[0])));
        // execute query
        TypedQuery<Project> query = em.createQuery(cq);

        return query.getResultList();

    }

    public List<Project> searchJoin(Map<String, String> queryParams) {

        String name = queryParams.get("name");

        // 1 create criteriaBuilder
        CriteriaBuilder cb = em.getCriteriaBuilder();
        // 2 create Query Builder
        CriteriaQuery<Project> cq = cb.createQuery(Project.class);

        // 3 Root Query select * from project
        Root<Project> root = cq.from(Project.class);

        // 5 create predicates
        // join project taskstatuses
        //Join<Object , Object> taskStatusJoin = (Join<Object , Object>)root.fetch("taskStatuses");

        root.fetch("taskStatuses");

//        cq.from(Project.class).join("taskStatuses");

        // joining project and task
        Predicate taskStatusJoinPredicate = cb.equal(root.get("id") , root.get("taskStatuses").get("project").get("id"));

        // 5 added predicates to where
        // execute query
        cq.select(root).where(taskStatusJoinPredicate);
        TypedQuery<Project> query = em.createQuery(cq);

        return query.getResultList();

    }

    public List<Project> searchSelectColumns(Map<String, String> queryParams) {

        String name = queryParams.get("name");

        // 1 create criteriaBuilder
        CriteriaBuilder cb = em.getCriteriaBuilder();
        // 2 create Query Builder
        CriteriaQuery<Project> cq = cb.createQuery(Project.class);

        // 3 Root Query select * from project
        Root<Project> root = cq.from(Project.class);



        // 5 create predicates
        Set<Predicate> predicates = new HashSet<>();
        if (name != null) {
            Predicate namePredicate = cb.equal(cb.upper(root.get("name")), name.toUpperCase());
            Predicate nameStartsPredicate = cb.like(cb.upper(root.get("name")), "%"+name.toUpperCase()+"%");

            predicates.add(namePredicate);
            predicates.add(nameStartsPredicate);

        }

        // 5 added predicates to where
        cq.select(cb.construct(Project.class , root.get("name")))
                .where(
                cb.or(predicates.toArray(new Predicate[0])));
        // execute query
        TypedQuery<Project> query = em.createQuery(cq);

        return query.getResultList();

    }

}
