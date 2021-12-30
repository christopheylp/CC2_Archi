package org.cc2.domain.project;

import org.cc2.domain.enums.WorkmanSkills;
import org.cc2.domain.workman.WorkmanId;
import org.cc2.kernel.ValueObjectId;

import java.util.ArrayList;
import java.util.Date;
import java.util.Objects;

public final class Project {
    private final ProjectId id;
    private final String adminId;
    private final String name;
    private final ArrayList<WorkmanSkills> requiredSkills;
    private final Date deadline;
    private final String location;
    private final ArrayList<WorkmanId> workmanAssigned ;

    public Project(ProjectId id, String adminId, String name, ArrayList<WorkmanSkills> requiredSkills, Date deadline, String location, ArrayList<WorkmanId> workmanAssigned) {
        this.id = Objects.requireNonNull(id);
        this.adminId = adminId;
        this.name = Objects.requireNonNull(name);
        this.requiredSkills = requiredSkills;
        this.deadline = deadline;
        this.location = location;
        this.workmanAssigned = workmanAssigned;
    }

    public static Project of(ProjectId id, String adminId, String name, ArrayList<WorkmanSkills> requiredSkills, Date deadline, String location, ArrayList<WorkmanId> workmanAssigned){
        return new Project(id, adminId, name, requiredSkills, deadline, location, workmanAssigned);
    }

    public ProjectId getId() {
        return this.id;
    }

    public String getName() {
        return this.name;
    }
}
