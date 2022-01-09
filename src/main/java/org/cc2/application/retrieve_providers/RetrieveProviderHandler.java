package org.cc2.application.retrieve_providers;

import org.cc2.domain.*;
import org.cc2.kernel.QueryHandler;

import java.util.Map;

public final class RetrieveProviderHandler implements QueryHandler<RetrieveProvider, Map<ProviderId, Provider>> {

    private final ProviderRepository providerRepository;

    public RetrieveProviderHandler(ProviderRepository providerRepository) {
        this.providerRepository = providerRepository;
    }

    @Override
    public Map<ProviderId, Provider> handle(RetrieveProvider query) {
        return providerRepository.findAll();
    }
}
