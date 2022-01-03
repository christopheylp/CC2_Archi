package org.cc2.application;

import org.cc2.domain.Project;
import org.cc2.domain.ProjectId;
import org.cc2.domain.ProjectRepository;
import org.cc2.domain.Provider;
import org.cc2.kernel.Event;
import org.cc2.kernel.EventDispatcher;

public class ProviderCreateProjectCommandHandler {
    private final ProjectRepository projectRepository;
    private final EventDispatcher<Event> eventEventDispatcher;

    public ProviderCreateProjectCommandHandler(ProjectRepository projectRepository, EventDispatcher<Event> eventEventDispatcher) {
        this.projectRepository = projectRepository;
        this.eventEventDispatcher = eventEventDispatcher;
    }

    public ProjectId handle(ProviderCreateProject providerCreateProject) {
        final ProjectId projectId = projectRepository.nextIdentity();
        Project project = new Project(projectId, providerCreateProject.adminId, providerCreateProject.name, providerCreateProject.requiredSkills, providerCreateProject.deadline, providerCreateProject.location, providerCreateProject.workmanAssigned);
        projectRepository.add(project);
        eventEventDispatcher.dispatch(new ProviderCreateProjectEvent(projectId));
        return projectId;
    }
}
