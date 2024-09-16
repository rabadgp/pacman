package com.inditex.proof.pacman.catalog.service.rest.controller;

import java.util.List;
import java.util.stream.Collectors;

import com.inditex.proof.pacman.catalog.service.application.filter.FilterProductQuery;
import com.inditex.proof.pacman.catalog.service.application.port.input.ProductUseCase;
import com.inditex.proof.pacman.catalog.service.rest.controller.mapper.ProductControllerMapper;
import lombok.AllArgsConstructor;
import org.openapitools.api.ProductsApi;
import org.openapitools.model.ProductResponseDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/api")
@AllArgsConstructor
public class ProductController implements ProductsApi {

    private ProductUseCase productUseCase;

    private ProductControllerMapper mapper;

    @Override
    public ResponseEntity<List<ProductResponseDTO>> findProductByCategoryAndMetrics(final String category, final List<String> metrics, final List<Double> weights) {
        FilterProductQuery filterProductQuery = FilterProductQuery.builder()
                                                                  .productCategory(category)
                                                                  .metricCodes(metrics)
                                                                  .metricWeights(weights)
                                                                  .build();
        List<ProductResponseDTO> response = productUseCase.filterProduct(filterProductQuery).stream().map(mapper::toProductResponseDTO).collect(Collectors.toList());
        if (response.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return ResponseEntity.ok(response);
    }
}
