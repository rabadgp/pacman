package com.inditex.proof.pacman.catalog.service.domain.exceptions;

public class ProductDomainException extends DomainException {

    public ProductDomainException(final String message) {
        super(message);
    }

    public ProductDomainException(final String message, final Throwable cause) {
        super(message, cause);
    }
}
