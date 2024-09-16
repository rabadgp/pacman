package com.inditex.proof.pacman.catalog.service.application.port.ouput;

import java.util.List;

import com.inditex.proof.pacman.catalog.service.domain.entity.Product;

public interface ProductRepository {

    List<Product> findProductByMetrics(Product product, List<Double> metricWeights);
}
