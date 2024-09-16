package com.inditex.proof.pacman.catalog.service.dataaccess.entity;

import java.util.Map;

import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.MapKeyColumn;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import lombok.Builder;

@Entity
@Table(name = "stocks_metric")
@PrimaryKeyJoinColumn(name = "stock_id")
public class StockUnitEntity extends MetricEntity {

    @ElementCollection
    @CollectionTable(name = "stocks_metric_size_mapping",
        joinColumns = {@JoinColumn(name = "stock_size_id", referencedColumnName = "id")})
    @MapKeyColumn(name = "size_label")
    @Column(name = "units")
    private Map<String, Long> stockBySize;

    public StockUnitEntity() {}

    @Builder
    protected StockUnitEntity(final Long id, final ProductEntity product, final Map<String, Long> stockBySize) {
        super(id, product);
        this.stockBySize = stockBySize;
    }

    public Map<String, Long> getStockBySize() {
        return stockBySize;
    }

    public void setStockBySize(final Map<String, Long> stockBySize) {
        this.stockBySize = stockBySize;
    }

    @Override
    public long getMetricValue() {
        return stockBySize.values().stream().reduce(Long::sum).orElse(0L);
    }
}
