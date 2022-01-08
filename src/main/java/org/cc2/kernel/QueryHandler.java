package org.cc2.kernel;

public interface QueryHandler<Q extends Query, R> {
    R handle(Q query);
}
