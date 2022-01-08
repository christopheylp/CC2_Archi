package org.cc2.domain;

import org.cc2.kernel.Repository;
import org.cc2.kernel.ValueObjectId;

import java.util.ArrayList;
import java.util.Map;

public interface SubscriptionRepository extends Repository<SubscriptionId, Subscription> {
    Map<SubscriptionId, Subscription> findAll();

    ArrayList<Subscription> findByUserId(ValueObjectId userId);
}
