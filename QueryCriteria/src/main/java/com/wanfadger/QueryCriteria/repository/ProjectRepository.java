package com.wanfadger.QueryCriteria.repository;

import org.springframework.stereotype.Repository;

import com.wanfadger.QueryCriteria.entity.Project;

import org.springframework.data.jpa.repository.JpaRepository;

@Repository()
public interface ProjectRepository extends JpaRepository<Project , String> {
}
