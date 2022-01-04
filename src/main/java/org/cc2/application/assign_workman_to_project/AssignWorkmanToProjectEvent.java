package org.cc2.application.assign_workman_to_project;

import org.cc2.domain.ProjectId;
import org.cc2.domain.WorkmanId;
import org.cc2.kernel.ApplicationEvent;

public final class AssignWorkmanToProjectEvent implements ApplicationEvent {
    private final ProjectId projectId;
    private final WorkmanId workmanId;

    public AssignWorkmanToProjectEvent(ProjectId projectId, WorkmanId workmanId) {
        this.projectId = projectId;
        this.workmanId = workmanId;
    }
}
