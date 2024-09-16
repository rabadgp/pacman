package com.inditex.proof.pacman.catalog.service.application;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import com.inditex.proof.pacman.catalog.service.application.exception.FilterProductQueryException;
import com.inditex.proof.pacman.catalog.service.application.filter.FilterMetricQueryResponse;
import com.inditex.proof.pacman.catalog.service.application.filter.FilterProductQuery;
import com.inditex.proof.pacman.catalog.service.application.mapper.ProductMapper;
import com.inditex.proof.pacman.catalog.service.application.port.input.ProductUseCase;
import com.inditex.proof.pacman.catalog.service.application.port.ouput.ProductRepository;
import com.inditex.proof.pacman.catalog.service.domain.entity.Product;
import org.springframework.stereotype.Service;

@Service
public class ProductUseCaseImpl implements ProductUseCase {

    private ProductRepository repository;

    private ProductMapper mapper;

    protected ProductUseCaseImpl(final ProductRepository repository, final ProductMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    @Override
    public List<FilterMetricQueryResponse> filterProduct(
        final FilterProductQuery filterProductQuery) {
        checkMetricCodesAndWeightSizes(filterProductQuery);
        checkMetricWeights(filterProductQuery);
        checkSumOfMetricWeights(filterProductQuery);
        checkMetricCodesAndWeightOrder(filterProductQuery);
        Product product = mapper.toProduct(filterProductQuery);
        return repository.findProductByMetrics(product, filterProductQuery.getMetricWeights())
                         .stream()
                         .map(mapper::toFilterMetricQueryResponse)
                         .collect(Collectors.toList());
    }

    private void checkMetricCodesAndWeightSizes(final FilterProductQuery filterProductQuery) {
        if (filterProductQuery.getMetricWeights() != null && !filterProductQuery.getMetricWeights().isEmpty()
            && filterProductQuery.getMetricWeights().size() != filterProductQuery.getMetricCodes().size()) {
            throw new FilterProductQueryException("Number of metrics and its associated weights does not match");
        }
    }

    private void checkSumOfMetricWeights(final FilterProductQuery filterProductQuery) {
        filterProductQuery.getMetricWeights().stream()
                          .reduce(Double::sum)
                          .filter(total -> Double.compare(total, 1.0) == 0)
                          .orElseThrow(() -> new FilterProductQueryException("The sum of metric's weights is not equal 1.0"));
    }

    private void checkMetricWeights(final FilterProductQuery filterProductQuery) {
        List<Double> metricWeights = filterProductQuery.getMetricWeights();
        if (metricWeights == null || metricWeights.isEmpty()) {
            BigDecimal sampleWeight = new BigDecimal(1.0 / filterProductQuery.getMetricCodes().size());
            BigDecimal sampleWeightRoundedUp = sampleWeight.setScale(1, RoundingMode.HALF_UP);
            BigDecimal sampleWeightRoundedDown = sampleWeight.setScale(1, RoundingMode.HALF_DOWN);
            List<Double> weights = new java.util.ArrayList<>(Collections.nCopies(filterProductQuery.getMetricCodes().size() - 1, sampleWeightRoundedDown.doubleValue()));
            weights.add(0, sampleWeightRoundedUp.doubleValue());
            filterProductQuery.setMetricWeights(weights);
        }
    }

    private void checkMetricCodesAndWeightOrder(final FilterProductQuery filterProductQuery) {
        Map<String, Double> map = new HashMap<>();
        List<String> keys = filterProductQuery.getMetricCodes();
        List<Double> values = filterProductQuery.getMetricWeights();

        for (int i = 0; i < keys.size(); i++) {
            map.put(keys.get(i), values.get(i));
        }
        keys.clear();
        values.clear();
        map.entrySet().stream().sorted(Map.Entry.<String, Double>comparingByValue().reversed()).forEach(entry -> {
            keys.add(entry.getKey());
            values.add(entry.getValue());
        });
        filterProductQuery.setMetricWeights(values);
        filterProductQuery.setMetricCodes(keys);

    }


}
