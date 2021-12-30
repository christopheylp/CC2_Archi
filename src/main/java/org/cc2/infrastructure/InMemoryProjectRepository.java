package org.cc2.infrastructure;

import org.cc2.domain.project.Project;
import org.cc2.domain.project.ProjectId;
import org.cc2.domain.project.ProjectRepository;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public final class InMemoryProjectRepository implements ProjectRepository {
    private final Map<ProjectId, Project> data = new ConcurrentHashMap<>();

    @Override
    public void save(Project project) {
        data.put(project.getId(), project);
    }

    @Override
    public Project byId(ProjectId projectId) {
        final Project project = data.get(projectId);
        if (project == null) {
            assert false;
            throw new RuntimeException("No project for " + project.getName());
        }
        return project;
    }

    @Override
    public Map<ProjectId, Project> findAll() {
        return data;
    }
}
