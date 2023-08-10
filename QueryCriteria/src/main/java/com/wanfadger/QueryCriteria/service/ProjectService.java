package com.wanfadger.QueryCriteria.service;

import java.util.List;
import java.util.Map;

import com.wanfadger.QueryCriteria.entity.Project;

public interface ProjectService {
     List<Project> search(Map<String, String> parameters);
     List<Project> searchJoin(Map<String, String> parameters);
     List<Project> searchSelectColumns(Map<String, String> parameters);
}
