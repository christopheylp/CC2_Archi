package org.cc2.domain.project;

import java.util.Map;

public final class ProjectService {
    private final ProjectRepository projectRepository;

    public ProjectService(ProjectRepository projectRepository) {
        this.projectRepository = projectRepository;
    }

    public void create(Project project) {
        this.projectRepository.save(project);
        System.out.println("The project "+project.getId()+" is now created!");
    }

    public Map<String, Project> all() {
        return this.projectRepository.findAll();
    }

    public Project byId(String projectId) {
        return this.projectRepository.byId(projectId);
    }

}
