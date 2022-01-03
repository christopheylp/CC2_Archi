package org.cc2.domain;

import org.cc2.kernel.Repository;

import java.util.Map;

public interface ProviderRepository extends Repository<ProviderId,Provider> {
    Map<ProviderId, Provider> findAll();
}
