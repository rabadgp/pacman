package com.inditex.proof.pacman.catalog.service.dataaccess.entity;

import java.util.List;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("t-shirt")
public class TShirtEntity extends ProductEntity {

    public TShirtEntity() {}

    public TShirtEntity(final Long value, final String name, final List<MetricEntity> metricEntities) {
        super(value, name, metricEntities);
    }

}
