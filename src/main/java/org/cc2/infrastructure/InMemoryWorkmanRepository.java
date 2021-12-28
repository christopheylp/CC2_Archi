package org.cc2.infrastructure;

import org.cc2.domain.workman.Workman;
import org.cc2.domain.workman.WorkmanRepository;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class InMemoryWorkmanRepository  implements WorkmanRepository {
    private final Map<String, Workman> data = new ConcurrentHashMap<>();

    @Override
    public void save(Workman workman) {
        data.put(workman.getId(), workman);
    }

    @Override
    public Workman byId(String workmanId) {
        final Workman workman = data.get(workmanId);
        if (workman == null) {
            assert false;
            throw new RuntimeException("No workman for " + workman.getName());
        }
        return workman;
    }

    @Override
    public Map<String, Workman> findAll() {
        return data;
    }
}
