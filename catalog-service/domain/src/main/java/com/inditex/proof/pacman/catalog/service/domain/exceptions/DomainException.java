package com.inditex.proof.pacman.catalog.service.domain.exceptions;

public class DomainException extends RuntimeException {

    protected DomainException(final String message) {
        super(message);
    }

    protected DomainException(final String message, final Throwable cause) {
        super(message, cause);
    }
}
