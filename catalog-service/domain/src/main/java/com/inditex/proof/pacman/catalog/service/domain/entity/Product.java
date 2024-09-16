package com.inditex.proof.pacman.catalog.service.domain.entity;

import java.util.ArrayList;
import java.util.List;

import com.inditex.proof.pacman.catalog.service.domain.AggregateRoot;
import com.inditex.proof.pacman.catalog.service.domain.value.ProductId;
import com.inditex.proof.pacman.catalog.service.domain.value.ProductName;

public abstract class Product extends AggregateRoot<ProductId> {

    private ProductName productName;

    private List<Metric> productMetrics = new ArrayList<>();

    protected Product() {super();}

    protected Product(final ProductId productId, final ProductName productName, final List<Metric> productMetrics) {
        super(productId);
        this.productName = productName;
        this.productMetrics = productMetrics;
    }

    public ProductName getProductName() {
        return productName;
    }

    public void setProductName(final ProductName productName) {
        this.productName = productName;
    }

    public List<Metric> getProductMetrics() {
        return productMetrics;
    }

    public void addMetric(Metric metric) {
        productMetrics.add(metric);
    }

    public List<Product> retrieveByCategory() {
        return null;
    }

}
