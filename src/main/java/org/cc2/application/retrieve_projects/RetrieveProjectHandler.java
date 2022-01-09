package org.cc2.application.retrieve_projects;

import org.cc2.domain.Project;
import org.cc2.domain.ProjectId;
import org.cc2.domain.ProjectRepository;
import org.cc2.kernel.QueryHandler;

import java.util.Map;

public final class RetrieveProjectHandler implements QueryHandler<RetrieveProject, Map<ProjectId,Project>> {

    private final ProjectRepository projectRepository;

    public RetrieveProjectHandler(ProjectRepository projectRepository) {
        this.projectRepository = projectRepository;
    }

    @Override
    public Map<ProjectId, Project> handle(RetrieveProject query) {
        return  projectRepository.findAll();
    }
}
