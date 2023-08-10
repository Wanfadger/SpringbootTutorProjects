package com.wanfadger.QueryCriteria.serviceImpl;

import lombok.RequiredArgsConstructor;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.wanfadger.QueryCriteria.dao.ProjectSearchDao;
import com.wanfadger.QueryCriteria.entity.Project;
import com.wanfadger.QueryCriteria.service.ProjectService;


@Service
@RequiredArgsConstructor
public class ProjectImpl implements ProjectService {
 private final ProjectSearchDao projectSearchDao;

    @Override
    public List<Project> search(Map<String, String> parameters) {
        return projectSearchDao.search(parameters);
    }

    @Override
    public List<Project> searchJoin(Map<String, String> parameters) {
        return projectSearchDao.searchJoin(parameters);
    }

    @Override
    public List<Project> searchSelectColumns(Map<String, String> parameters) {
        return projectSearchDao.searchSelectColumns(parameters);
    }
}
