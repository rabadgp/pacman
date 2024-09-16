package com.inditex.proof.pacman.catalog.service.domain.value;

public class ProductName {

    private String name;

    public ProductName(final String description) {
        this.name = description;
    }

    public String getName() {
        return name;
    }
}
