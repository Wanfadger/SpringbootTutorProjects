package com.wanfadger.QueryCriteria.controller;

import java.util.List;
import java.util.Map;

import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.wanfadger.QueryCriteria.entity.Project;
import com.wanfadger.QueryCriteria.service.ProjectService;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@Tag(
        name = "Project",
        description = "Project Management Endpoints"
)
public class ProjectController {
    private final ProjectService projectService;

     @GetMapping("/projectSearch")
     public List<Project> search(Map<String, String> parameters){
        return projectService.search(parameters);
    }
}
