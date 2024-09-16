package com.inditex.proof.pacman.catalog.service.application.filter;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@AllArgsConstructor
public class FilterProductQuery {

    private final String productCategory;

    private List<String> metricCodes;

    private List<Double> metricWeights;
}
