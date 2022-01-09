package org.cc2.infrastructure;

import org.cc2.domain.Workman;
import org.cc2.domain.WorkmanId;
import org.cc2.domain.WorkmanRepository;
import org.cc2.kernel.exception.NoSuchEntityException;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

public final class InMemoryWorkmanRepository  implements WorkmanRepository {
    private final Map<WorkmanId, Workman> data = new ConcurrentHashMap<>();
    private final AtomicInteger count = new AtomicInteger(0);

    @Override
    public Map<WorkmanId, Workman> findAll() {
        return data;
    }

    @Override
    public WorkmanId nextIdentity() {
        return new WorkmanId(count.incrementAndGet());
    }

    @Override
    public Workman findById(WorkmanId id) throws NoSuchEntityException {
        final Workman workman = data.get(id);
        if (workman == null) {
            assert false;
            throw new RuntimeException("No workman for " + workman.getName());
        }
        return workman;    }

    @Override
    public void add(Workman entity) {
        data.put(entity.getId(), entity);
    }

    @Override
    public void delete(WorkmanId id) {
        data.remove(id);
    }
}
