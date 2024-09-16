package com.inditex.proof.pacman.catalog.service.domain;

public class AggregateRoot<T> extends BaseEntity<T> {

    protected AggregateRoot() {super();}

    protected AggregateRoot(final T t) {
        super(t);
    }
}
