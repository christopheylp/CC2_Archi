package org.cc2.domain;

import org.cc2.kernel.Repository;

import java.util.Map;

public interface ProjectRepository extends Repository<ProjectId,Project> {
    Map<ProjectId, Project> findAll();
}
