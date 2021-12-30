package org.cc2.domain.provider;

import org.cc2.kernel.Id;

public final class ProviderId extends Id {
    public ProviderId(int value) {
        super(value);
    }

    @Override
    public String toString() {
        return "ProviderId{"+this.getValue()+"}";
    }
}
