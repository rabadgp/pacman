package com.inditex.proof.pacman.catalog.service.dataaccess.mapper;

import java.util.List;
import java.util.Locale;
import java.util.Map.Entry;
import java.util.stream.Collectors;

import com.inditex.proof.pacman.catalog.service.application.exception.ApplicationException;
import com.inditex.proof.pacman.catalog.service.dataaccess.entity.MetricEntity;
import com.inditex.proof.pacman.catalog.service.dataaccess.entity.ProductEntity;
import com.inditex.proof.pacman.catalog.service.dataaccess.entity.SalesUnitEntity;
import com.inditex.proof.pacman.catalog.service.dataaccess.entity.StockUnitEntity;
import com.inditex.proof.pacman.catalog.service.dataaccess.entity.TShirtEntity;
import com.inditex.proof.pacman.catalog.service.domain.entity.Metric;
import com.inditex.proof.pacman.catalog.service.domain.entity.Product;
import com.inditex.proof.pacman.catalog.service.domain.entity.SaleUnit;
import com.inditex.proof.pacman.catalog.service.domain.entity.StockUnit;
import com.inditex.proof.pacman.catalog.service.domain.entity.TShirt;
import com.inditex.proof.pacman.catalog.service.domain.exceptions.ProductDomainException;
import com.inditex.proof.pacman.catalog.service.domain.value.MetricId;
import com.inditex.proof.pacman.catalog.service.domain.value.ProductId;
import com.inditex.proof.pacman.catalog.service.domain.value.ProductName;
import com.inditex.proof.pacman.catalog.service.domain.value.ProductSize;
import org.springframework.stereotype.Component;

@Component
public class ProductEntityMapper {

    public ProductEntity toProductEntity(final Product source) {
        ProductEntity productEntity = ProductEntityFactory.build(source);
        productEntity.getMetrics().forEach(metricEntity -> metricEntity.setProduct(productEntity));
        return productEntity;
    }

    public Product toProduct(final ProductEntity productEntity) {
        return ProductEntityFactory.build(productEntity);
    }

    static class ProductEntityFactory {

        static ProductEntity build(Product product) {
            if (product instanceof TShirt) {
                List<MetricEntity> metricEntities = product.getProductMetrics().stream().map(MetricEntityFactory::build).collect(Collectors.toList());
                TShirtEntity tShirtEntity = new TShirtEntity();
                tShirtEntity.setMetrics(metricEntities);
                return tShirtEntity;
            }
            throw new ApplicationException("Cannot mapper ProductEntity from domain Metric object");
        }

        public static Product build(final ProductEntity productEntity) {
            if ("t-shirt".equals(productEntity.getDecriminatorValue())) {
                return new TShirt(new ProductId(productEntity.getId()), new ProductName(productEntity.getName()),
                                  List.copyOf(productEntity.getMetrics().stream().map(MetricEntityFactory::build).collect(Collectors.toList())));
            }
            throw new ProductDomainException("Product cannot be built because category does not exist");
        }
    }

    static class MetricEntityFactory {

        static MetricEntity build(final Metric metric) {
            if (metric instanceof SaleUnit) {
                return new SalesUnitEntity();
            } else if (metric instanceof StockUnit) {
                return new StockUnitEntity();
            }
            throw new ApplicationException("Cannot mapper MetricEntity from domain Metric object");
        }

        static Metric build(final MetricEntity metric) {
            if (metric instanceof SalesUnitEntity) {
                return new SaleUnit(new MetricId(metric.getId()), ((SalesUnitEntity) metric).getSales());
            } else if (metric instanceof StockUnitEntity) {
                return new StockUnit(new MetricId(metric.getId()),
                                     ((StockUnitEntity) metric)
                                         .getStockBySize()
                                         .entrySet()
                                         .stream()
                                         .collect(Collectors
                                                      .toMap(stringLongEntry -> ProductSize.valueBySizeCode(
                                                          stringLongEntry.getKey()
                                                                         .toUpperCase(
                                                                             Locale.ROOT)), Entry::getValue)));
            }
            throw new ApplicationException("Cannot mapper Metric from MetricEntity object");
        }
    }


}
