package org.cc2.domain.project;

import org.cc2.kernel.Id;

public class ProjectId extends Id {
    public ProjectId(int value) {
        super(value);
    }

    @Override
    public String toString() {
        return "ProjectId{"+this.getValue()+"}";
    }
}
