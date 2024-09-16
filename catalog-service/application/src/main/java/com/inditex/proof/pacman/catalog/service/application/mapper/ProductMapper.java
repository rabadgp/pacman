package com.inditex.proof.pacman.catalog.service.application.mapper;

import java.util.Locale;

import com.inditex.proof.pacman.catalog.service.application.filter.FilterMetricQueryResponse;
import com.inditex.proof.pacman.catalog.service.application.filter.FilterProductQuery;
import com.inditex.proof.pacman.catalog.service.domain.MetricFactory;
import com.inditex.proof.pacman.catalog.service.domain.ProductFactory;
import com.inditex.proof.pacman.catalog.service.domain.entity.Metric;
import com.inditex.proof.pacman.catalog.service.domain.entity.Product;
import com.inditex.proof.pacman.catalog.service.domain.value.MetricType;
import com.inditex.proof.pacman.catalog.service.domain.value.ProductCategory;
import org.springframework.stereotype.Component;

@Component
public class ProductMapper {

    public Product toProduct(FilterProductQuery source) {
        ProductCategory category = ProductCategory.valueOf(source.getProductCategory().toUpperCase(Locale.ROOT));
        Product product = ProductFactory.build(category);
        source.getMetricCodes().forEach(metricCode -> {
            MetricType metricType = MetricType.valueByMetricCode(metricCode);
            Metric metric = MetricFactory.build(metricType);
            product.addMetric(metric);
        });
        return product;
    }

    public FilterMetricQueryResponse toFilterMetricQueryResponse(Product source) {
        return new FilterMetricQueryResponse(source.getId().getValue(), source.getProductName().getName());
    }
}
