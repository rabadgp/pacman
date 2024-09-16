package com.inditex.proof.pacman.catalog.service.domain.entity;

import java.util.List;

import com.inditex.proof.pacman.catalog.service.domain.value.ProductId;
import com.inditex.proof.pacman.catalog.service.domain.value.ProductName;

public class TShirt extends Product {

    public TShirt() {}

    public TShirt(
        final ProductId productId, final ProductName productName,
        final List<Metric> productMetrics) {
        super(productId, productName, productMetrics);
    }

    public static Builder builder() {
        return new Builder();
    }

    private TShirt(final Builder builder) {
        super(builder.productId, builder.productName, builder.productMetrics);
    }

    public static final class Builder {

        private ProductId productId;

        private ProductName productName;

        private List<Metric> productMetrics;

        private Builder() {}

        public static Builder builder() {
            return new Builder();
        }

        public Builder id(final ProductId val) {
            productId = val;
            return this;
        }

        public Builder productName(final ProductName val) {
            productName = val;
            return this;
        }

        public Builder productMetrics(final List<Metric> val) {
            productMetrics = val;
            return this;
        }

        public TShirt build() {
            return new TShirt(this);
        }
    }
}
