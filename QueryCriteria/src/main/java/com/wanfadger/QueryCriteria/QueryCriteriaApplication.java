package com.wanfadger.QueryCriteria;

import com.wanfadger.QueryCriteria.service.ProjectService;
import lombok.RequiredArgsConstructor;
import net.datafaker.Faker;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.wanfadger.QueryCriteria.entity.Project;
import com.wanfadger.QueryCriteria.entity.TaskStatus;
import com.wanfadger.QueryCriteria.repository.ProjectRepository;

@SpringBootApplication
@RequiredArgsConstructor
public class QueryCriteriaApplication implements CommandLineRunner {

	private final Faker faker;
	private final ProjectRepository projectRepository;
	private final ProjectService projectService;

	public static void main(String[] args) {
		SpringApplication.run(QueryCriteriaApplication.class, args);
	}



	@Override
	public void run(String... args) throws Exception {
//  Project project = new Project(faker.commerce().brand());
//
//		Set<TaskStatus> taskStatuses = Set.of(
//			new TaskStatus("todo", 0, project),
//			new TaskStatus("pending", 1, project),
//			new TaskStatus("done", 2, project)
//			);
//
//			project.setTaskStatuses(taskStatuses);
//		Project saved = 	projectRepository.save(project);
//		System.out.println("Hello Uganda");
//		System.out.println(saved.getId());

		System.out.println("SEARCH BY CRITERIA");
		Map<String , String> map = new HashMap<>();
		map.put("name" , "gopro");
		List<Project> search = projectService.searchJoin(map);
		System.out.println(search.stream().map(Project::getName).toList());
		System.out.println(search.stream().flatMap(p -> p.getTaskStatuses().stream().map(TaskStatus::getName)).toList());
	}
}
