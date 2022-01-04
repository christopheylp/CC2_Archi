package org.cc2.application.assign_workman_to_project;

import org.cc2.application.create_project_by_provider.ProviderCreateProjectEvent;
import org.cc2.domain.*;
import org.cc2.kernel.CommandHandler;
import org.cc2.kernel.Event;
import org.cc2.kernel.EventDispatcher;

public final class AssignWorkmanToProjectCommandHandler implements CommandHandler<AssignWorkmanToProject, ProjectId> {
    private final ProviderRepository providerRepository;
    private final WorkmanRepository workmanRepository;
    private final ProjectRepository projectRepository;
    private final EventDispatcher<Event> eventEventDispatcher;

    public AssignWorkmanToProjectCommandHandler(ProviderRepository providerRepository, WorkmanRepository workmanRepository, ProjectRepository projectRepository, EventDispatcher<Event> eventEventDispatcher) {
        this.providerRepository = providerRepository;
        this.workmanRepository = workmanRepository;
        this.projectRepository = projectRepository;
        this.eventEventDispatcher = eventEventDispatcher;
    }

    public boolean verifySubscription(ProviderId providerId, WorkmanId workmanId) {
        //TODO
        return true;
    }

    public boolean verifySkills(ProjectId projectId, WorkmanId workmanId) {
        //TODO
        return true;
    }

    @Override
    public ProjectId handle(AssignWorkmanToProject assignWorkmanToProject) {
        if (verifySubscription(assignWorkmanToProject.providerId, assignWorkmanToProject.workmanId) && verifySkills(assignWorkmanToProject.projectId, assignWorkmanToProject.workmanId)) {
            Project project = projectRepository.findById(assignWorkmanToProject.projectId);
            project.addWorkmanAssigned(assignWorkmanToProject.workmanId);
            this.projectRepository.add(project);
            eventEventDispatcher.dispatch(new AssignWorkmanToProjectEvent(assignWorkmanToProject.projectId, assignWorkmanToProject.workmanId));

            return assignWorkmanToProject.projectId;
        } else {
            throw new RuntimeException(); //TODO faire une exception specifique
        }
    }
}
