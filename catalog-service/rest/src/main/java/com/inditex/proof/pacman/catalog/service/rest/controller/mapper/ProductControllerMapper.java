package com.inditex.proof.pacman.catalog.service.rest.controller.mapper;

import com.inditex.proof.pacman.catalog.service.application.filter.FilterMetricQueryResponse;
import org.openapitools.model.ProductResponseDTO;
import org.springframework.stereotype.Component;

@Component
public class ProductControllerMapper {

    public ProductResponseDTO toProductResponseDTO(FilterMetricQueryResponse source) {
        ProductResponseDTO productResponseDTO = new ProductResponseDTO();
        productResponseDTO.setId(source.getProductId());
        productResponseDTO.setName(source.getProductName());
        return productResponseDTO;
    }
}
