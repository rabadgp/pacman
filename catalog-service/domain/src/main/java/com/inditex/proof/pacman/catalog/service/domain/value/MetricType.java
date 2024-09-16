package com.inditex.proof.pacman.catalog.service.domain.value;

import java.util.Arrays;
import java.util.Locale;

import com.inditex.proof.pacman.catalog.service.domain.exceptions.ProductDomainException;

public enum MetricType {
    SALE_UNITS("sales"),
    STOCK_UNITS("stock");

    private String metricCode;

    MetricType(String metricCode) {
        this.metricCode = metricCode;
    }

    public static MetricType valueByMetricCode(String metricCode) {
        return Arrays.stream(values()).filter(code -> code.metricCode.equals(metricCode.toLowerCase(Locale.ROOT)))
                     .findFirst()
                     .orElseThrow(() -> new ProductDomainException(metricCode + " is an unmanaged metric code!"));
    }
}
