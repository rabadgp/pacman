package com.inditex.proof.pacman.catalog.service.domain.entity;

import java.util.Map;

import com.inditex.proof.pacman.catalog.service.domain.value.MetricId;
import com.inditex.proof.pacman.catalog.service.domain.value.ProductSize;

public class StockUnit extends Metric {

    private Map<ProductSize, Long> stock;

    public StockUnit() {
        super();
    }

    public StockUnit(final MetricId metricId, Map<ProductSize, Long> stock) {
        super(metricId);
        this.stock = stock;
    }

    public Map<ProductSize, Long> getStock() {
        return stock;
    }

    public void setStock(final Map<ProductSize, Long> stock) {
        this.stock = stock;
    }


}
