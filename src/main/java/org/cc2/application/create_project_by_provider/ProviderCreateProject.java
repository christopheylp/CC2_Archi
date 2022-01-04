package org.cc2.application.create_project_by_provider;

import org.cc2.domain.*;
import org.cc2.kernel.Command;

import java.util.ArrayList;
import java.util.Date;
import java.util.Objects;

public final class ProviderCreateProject implements Command {
    public final ProviderId adminId;
    public final String name;
    public final ArrayList<WorkmanSkills> requiredSkills;
    public final Date deadline;
    public final String location;
    public final ArrayList<WorkmanId> workmanAssigned ;

    public ProviderCreateProject(ProviderId adminId, String name, ArrayList<WorkmanSkills> requiredSkills, Date deadline, String location, ArrayList<WorkmanId> workmanAssigned) {
        this.adminId = adminId;
        this.name = Objects.requireNonNull(name);
        this.requiredSkills = requiredSkills;
        this.deadline = deadline;
        this.location = location;
        this.workmanAssigned = workmanAssigned;
    }

    public static ProviderCreateProject of(ProviderId adminId, String name, ArrayList<WorkmanSkills> requiredSkills, Date deadline, String location, ArrayList<WorkmanId> workmanAssigned){
        return new ProviderCreateProject(adminId, name, requiredSkills, deadline, location, workmanAssigned);
    }


}
