package org.cc2.domain.provider;

import org.cc2.domain.project.Project;

import java.util.Map;

public interface ProviderRepository {
    void save(Provider provider);

    Provider byId(String providerId);

    Map<String, Provider> findAll();
}
