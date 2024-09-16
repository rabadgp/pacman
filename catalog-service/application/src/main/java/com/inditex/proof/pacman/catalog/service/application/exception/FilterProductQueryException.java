package com.inditex.proof.pacman.catalog.service.application.exception;

public class FilterProductQueryException extends ApplicationException {

    public FilterProductQueryException(final String message) {
        super(message);
    }

    protected FilterProductQueryException(final String message, final Throwable cause) {
        super(message, cause);
    }
}
