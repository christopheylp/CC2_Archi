package org.cc2.application.retrieve_workmans;

import org.cc2.domain.*;
import org.cc2.exposition.WorkmanController;
import org.cc2.kernel.QueryHandler;

import java.util.Map;

public class RetrieveWorkmanHandler implements QueryHandler<RetrieveWorkman, Map<WorkmanId, Workman>> {

    private final WorkmanRepository workmanRepository;

    public RetrieveWorkmanHandler(WorkmanRepository workmanRepository) {
        this.workmanRepository = workmanRepository;
    }

    @Override
    public Map<WorkmanId, Workman> handle(RetrieveWorkman query) {
        return workmanRepository.findAll();
    }
}
