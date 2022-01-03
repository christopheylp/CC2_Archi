package org.cc2.infrastructure;

import org.cc2.domain.*;
import org.cc2.kernel.NoSuchEntityException;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

public final class InMemoryProviderRepository implements ProviderRepository {
    private final Map<ProviderId, Provider> data = new ConcurrentHashMap<>();
    private final AtomicInteger count = new AtomicInteger(0);

    @Override
    public Map<ProviderId, Provider> findAll() {
        return data;
    }

    @Override
    public ProviderId nextIdentity() {
        return new ProviderId(count.incrementAndGet());
    }

    @Override
    public Provider findById(ProviderId id) throws NoSuchEntityException {
        final Provider provider = data.get(id);
        if (provider == null) {
            assert false;
            throw new RuntimeException("No provider for " + provider.getName());
        }
        return provider;
    }

    @Override
    public void add(Provider entity) {
        data.put(entity.getId(), entity);
    }

    @Override
    public void delete(ProviderId id) {
        data.remove(id);
    }
}
