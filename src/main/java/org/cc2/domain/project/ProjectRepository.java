package org.cc2.domain.project;

import java.util.Map;

public interface ProjectRepository {
    void save(Project project);

    Project byId(String projectId);

    Map<String, Project> findAll();
}
