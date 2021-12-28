package org.cc2.domain.provider;

import java.util.Map;

public final class ProviderService {
    private final ProviderRepository providerRepository;

    public ProviderService(ProviderRepository projectRepository) {
        this.providerRepository = projectRepository;
    }

    public void create(Provider provider) {
        this.providerRepository.save(provider);
        System.out.println("The provider "+provider.getId()+" is now registered!");
    }

    public Map<String, Provider> all() {
        return this.providerRepository.findAll();
    }

    public Provider byId(String projectId) {
        return this.providerRepository.byId(projectId);
    }
}
