package org.cc2.infrastructure;

import org.cc2.domain.provider.Provider;
import org.cc2.domain.provider.ProviderRepository;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public final class InMemoryProviderRepository implements ProviderRepository {
    private final Map<String, Provider> data = new ConcurrentHashMap<>();

    @Override
    public void save(Provider provider) {
        data.put(provider.getId(), provider);
    }

    @Override
    public Provider byId(String providerId) {
        final Provider provider = data.get(providerId);
        if (provider == null) {
            assert false;
            throw new RuntimeException("No provider for " + provider.getName());
        }
        return provider;
    }

    @Override
    public Map<String, Provider> findAll() {
        return data;
    }
}
