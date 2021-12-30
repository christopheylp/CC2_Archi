package org.cc2.infrastructure;

import org.cc2.domain.provider.Provider;
import org.cc2.domain.provider.ProviderId;
import org.cc2.domain.provider.ProviderRepository;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public final class InMemoryProviderRepository implements ProviderRepository {
    private final Map<ProviderId, Provider> data = new ConcurrentHashMap<>();

    @Override
    public void save(Provider provider) {
        data.put(provider.getId(), provider);
    }

    @Override
    public Provider byId(ProviderId providerId) {
        final Provider provider = data.get(providerId);
        if (provider == null) {
            assert false;
            throw new RuntimeException("No provider for " + provider.getName());
        }
        return provider;
    }

    @Override
    public Map<ProviderId, Provider> findAll() {
        return data;
    }
}
