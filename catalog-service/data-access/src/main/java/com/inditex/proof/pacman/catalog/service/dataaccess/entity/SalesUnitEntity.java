package com.inditex.proof.pacman.catalog.service.dataaccess.entity;

import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import lombok.Builder;

@Entity
@Table(name = "sales_metric")
@PrimaryKeyJoinColumn(name = "sales_id")
public class SalesUnitEntity extends MetricEntity {

    private Long sales;

    public SalesUnitEntity() {}

    @Builder
    protected SalesUnitEntity(final Long id, final ProductEntity product, final Long sales) {
        super(id, product);
        this.sales = sales;
    }

    public Long getSales() {
        return sales;
    }

    public void setSales(final Long sales) {
        this.sales = sales;
    }

    @Override
    public long getMetricValue() {
        return sales;
    }
}
