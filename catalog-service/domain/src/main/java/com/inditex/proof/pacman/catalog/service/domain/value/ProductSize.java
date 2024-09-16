package com.inditex.proof.pacman.catalog.service.domain.value;

import java.util.Arrays;
import java.util.Locale;

import com.inditex.proof.pacman.catalog.service.domain.exceptions.ProductDomainException;

public enum ProductSize {
    SMALL("S"),
    MEDIUM("M"),
    LARGE("L");

    private String sizeCode;

    ProductSize(String sizeCode) {
        this.sizeCode = sizeCode;
    }

    public String getSizeCode() {
        return this.sizeCode;
    }

    public static ProductSize valueBySizeCode(String sizeCode) {
        return Arrays.stream(values()).filter(code -> code.getSizeCode().equals(sizeCode.toUpperCase(Locale.ROOT)))
                     .findFirst()
                     .orElseThrow(() -> new ProductDomainException(sizeCode + " is an unmanaged metric code!"));
    }
}
