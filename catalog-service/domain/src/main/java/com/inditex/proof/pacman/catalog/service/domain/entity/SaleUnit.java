package com.inditex.proof.pacman.catalog.service.domain.entity;

import com.inditex.proof.pacman.catalog.service.domain.value.MetricId;

public class SaleUnit extends Metric {

    private Long sales;

    public SaleUnit() {
        super();
    }

    public SaleUnit(final MetricId metricId, final Long sales) {
        super(metricId);
        this.sales = sales;
    }

    public Long getSales() {
        return sales;
    }

    public void setSales(final Long sales) {
        this.sales = sales;
    }
}
