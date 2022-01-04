package org.cc2.application.create_project_by_provider;

import org.cc2.domain.ProjectId;
import org.cc2.kernel.ApplicationEvent;

public final class ProviderCreateProjectEvent implements ApplicationEvent {
    private final ProjectId projectId;

    public ProviderCreateProjectEvent(ProjectId projectId) {
        this.projectId = projectId;
    }
}
