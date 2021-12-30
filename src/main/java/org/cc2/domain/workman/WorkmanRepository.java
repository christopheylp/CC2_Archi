package org.cc2.domain.workman;

import java.util.Map;

public interface WorkmanRepository {
    void save(Workman workman);

    Workman byId(WorkmanId workmanId);

    Map<WorkmanId, Workman> findAll();
}
