package org.cc2.domain.project;

import java.util.Map;

public interface ProjectRepository {
    void save(Project project);

    Project byId(ProjectId projectId);

    Map<ProjectId, Project> findAll();
}
