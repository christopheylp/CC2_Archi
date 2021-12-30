package org.cc2.infrastructure;

import org.cc2.domain.workman.Workman;
import org.cc2.domain.workman.WorkmanId;
import org.cc2.domain.workman.WorkmanRepository;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class InMemoryWorkmanRepository  implements WorkmanRepository {
    private final Map<WorkmanId, Workman> data = new ConcurrentHashMap<>();

    @Override
    public void save(Workman workman) {
        data.put(workman.getId(), workman);
    }

    @Override
    public Workman byId(WorkmanId workmanId) {
        final Workman workman = data.get(workmanId);
        if (workman == null) {
            assert false;
            throw new RuntimeException("No workman for " + workman.getName());
        }
        return workman;
    }

    @Override
    public Map<WorkmanId, Workman> findAll() {
        return data;
    }
}
