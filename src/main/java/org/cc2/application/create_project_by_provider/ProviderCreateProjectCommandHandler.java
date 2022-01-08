package org.cc2.application.create_project_by_provider;

import org.cc2.domain.Project;
import org.cc2.domain.ProjectId;
import org.cc2.domain.ProjectRepository;
import org.cc2.kernel.CommandHandler;
import org.cc2.kernel.Event;
import org.cc2.kernel.EventDispatcher;

public final class ProviderCreateProjectCommandHandler implements CommandHandler<ProviderCreateProject,ProjectId> {
    private final ProjectRepository projectRepository;
    private final EventDispatcher<Event> eventEventDispatcher;

    public ProviderCreateProjectCommandHandler(ProjectRepository projectRepository, EventDispatcher<Event> eventEventDispatcher) {
        this.projectRepository = projectRepository;
        this.eventEventDispatcher = eventEventDispatcher;
    }

    //TODO verifier l'abonnement lors de la creation
    @Override
    public ProjectId handle(ProviderCreateProject providerCreateProject) {
        final ProjectId projectId = projectRepository.nextIdentity();
        Project project = new Project(projectId, providerCreateProject.adminId, providerCreateProject.name, providerCreateProject.requiredSkills, providerCreateProject.dailyPrice, providerCreateProject.deadline, providerCreateProject.location, providerCreateProject.workmanAssigned);
        projectRepository.add(project);
        eventEventDispatcher.dispatch(new ProviderCreateProjectEvent(projectId));
        return projectId;
    }
}
