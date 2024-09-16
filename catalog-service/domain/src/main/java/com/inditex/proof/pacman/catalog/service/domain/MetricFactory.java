package com.inditex.proof.pacman.catalog.service.domain;

import com.inditex.proof.pacman.catalog.service.domain.entity.Metric;
import com.inditex.proof.pacman.catalog.service.domain.entity.SaleUnit;
import com.inditex.proof.pacman.catalog.service.domain.entity.StockUnit;
import com.inditex.proof.pacman.catalog.service.domain.exceptions.ProductDomainException;
import com.inditex.proof.pacman.catalog.service.domain.value.MetricType;

public class MetricFactory {

    public static Metric build(final MetricType metricType) {
        if (metricType == MetricType.SALE_UNITS) {
            return new SaleUnit();
        } else if (metricType == MetricType.STOCK_UNITS) {
            return new StockUnit();
        }
        throw new ProductDomainException("Metric cannot be built because metric type does not exist");
    }
}
