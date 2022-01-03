package org.cc2.domain;

import org.cc2.kernel.Repository;

import java.util.Map;

public interface WorkmanRepository extends Repository<WorkmanId,Workman> {
    Map<WorkmanId, Workman> findAll();
}
