package com.inditex.proof.pacman.catalog.service.domain.entity;

import com.inditex.proof.pacman.catalog.service.domain.BaseEntity;
import com.inditex.proof.pacman.catalog.service.domain.value.MetricId;

public abstract class Metric extends BaseEntity<MetricId> {

    protected Metric() {}

    protected Metric(final MetricId metricId) {
        super(metricId);
    }
    

}
