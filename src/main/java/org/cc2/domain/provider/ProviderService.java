package org.cc2.domain.provider;

import org.cc2.domain.project.ProjectId;

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

    public Map<ProviderId, Provider> all() {
        return this.providerRepository.findAll();
    }

    public Provider byId(ProviderId providerId) {
        return this.providerRepository.byId(providerId);
    }
}
