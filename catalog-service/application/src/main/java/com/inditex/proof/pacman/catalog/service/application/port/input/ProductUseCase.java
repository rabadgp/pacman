package com.inditex.proof.pacman.catalog.service.application.port.input;

import java.util.List;

import com.inditex.proof.pacman.catalog.service.application.filter.FilterMetricQueryResponse;
import com.inditex.proof.pacman.catalog.service.application.filter.FilterProductQuery;
import javax.validation.Valid;

public interface ProductUseCase {

    List<FilterMetricQueryResponse> filterProduct(@Valid FilterProductQuery filterProductQuery);
}
