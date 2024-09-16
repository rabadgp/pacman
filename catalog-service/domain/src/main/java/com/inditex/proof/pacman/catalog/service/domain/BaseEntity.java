package com.inditex.proof.pacman.catalog.service.domain;

import java.util.Objects;

public abstract class BaseEntity<ID> {

    private ID id;

    protected BaseEntity() {}

    protected BaseEntity(final ID id) {
        this.id = id;
    }

    public ID getId() {
        return id;
    }

    public void setId(final ID id) {
        this.id = id;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        final BaseEntity<?> that = (BaseEntity<?>) o;
        return id.equals(that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

}


