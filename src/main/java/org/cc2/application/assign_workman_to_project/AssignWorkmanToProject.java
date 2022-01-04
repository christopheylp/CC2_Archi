package org.cc2.application.assign_workman_to_project;

import org.cc2.application.create_workman.CreateWorkman;
import org.cc2.domain.ProjectId;
import org.cc2.domain.ProviderId;
import org.cc2.domain.WorkmanId;
import org.cc2.domain.WorkmanSkills;
import org.cc2.kernel.Command;

import java.util.ArrayList;

public final class AssignWorkmanToProject implements Command {
    public final ProviderId providerId;
    public final WorkmanId workmanId;
    public final ProjectId projectId;

    public AssignWorkmanToProject(ProviderId providerId, WorkmanId workmanId, ProjectId projectId) {
        this.providerId = providerId;
        this.workmanId = workmanId;
        this.projectId = projectId;
    }

    public static AssignWorkmanToProject of(ProviderId providerId, WorkmanId workmanId, ProjectId projectId){
        return new AssignWorkmanToProject(providerId, workmanId, projectId);
    }
}
