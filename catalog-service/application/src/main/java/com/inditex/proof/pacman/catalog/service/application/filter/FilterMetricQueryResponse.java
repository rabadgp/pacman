package com.inditex.proof.pacman.catalog.service.application.filter;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class FilterMetricQueryResponse {

    private final Long productId;

    private final String productName;
}
