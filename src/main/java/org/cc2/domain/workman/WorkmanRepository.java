package org.cc2.domain.workman;

import java.util.Map;

public interface WorkmanRepository {
    void save(Workman workman);

    Workman byId(String workmanId);

    Map<String, Workman> findAll();
}
