package org.cc2.domain.workman;

import org.cc2.kernel.Id;
import org.cc2.kernel.ValueObjectId;

import java.util.Objects;

public final class WorkmanId extends Id {

    public WorkmanId(int value) {
        super(value);
    }

    @Override
    public String toString() {
        return "WorkmanId{"+this.getValue()+"}";
    }
}
