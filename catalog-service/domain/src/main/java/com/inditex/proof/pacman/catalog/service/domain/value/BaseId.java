package com.inditex.proof.pacman.catalog.service.domain.value;

import java.util.Objects;

public class BaseId<T> {

    T value;

    public BaseId(final T id) {
        this.value = id;
    }

    public T getValue() {
        return value;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        final BaseId<?> baseId = (BaseId<?>) o;
        return value.equals(baseId.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }
}
