package org.cc2.domain.workman;

import java.util.Map;

public final class WorkmanService {
    private final WorkmanRepository workmanRepository;

    public WorkmanService(WorkmanRepository workmanRepository) {
        this.workmanRepository = workmanRepository;
    }

    public void create(Workman workman) {
        this.workmanRepository.save(workman);
        System.out.println("The workman "+workman.getId()+" is now registered!");
    }

    public Map<String, Workman> all() {
        return this.workmanRepository.findAll();
    }

    public Workman byId(String projectId) {
        return this.workmanRepository.byId(projectId);
    }
}
