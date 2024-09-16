package com.inditex.proof.pacman.catalog.service.dataaccess.adapter;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import com.inditex.proof.pacman.catalog.service.application.port.ouput.ProductRepository;
import com.inditex.proof.pacman.catalog.service.dataaccess.entity.MetricEntity;
import com.inditex.proof.pacman.catalog.service.dataaccess.entity.ProductEntity;
import com.inditex.proof.pacman.catalog.service.dataaccess.mapper.ProductEntityMapper;
import com.inditex.proof.pacman.catalog.service.domain.entity.Product;
import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Join;
import javax.persistence.criteria.Root;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class ProductRepositoryImpl implements ProductRepository {

    private EntityManager entityManager;

    private ProductEntityMapper mapper;

    @Override
    public List<Product> findProductByMetrics(
        final Product product, final List<Double> metricWeights) {
        List<Product> result = new ArrayList<>();
        ProductEntity productEntity = mapper.toProductEntity(product);
        List<MetricEntity> productMetrics = productEntity.getMetrics();
        for (int i = 0; i < productMetrics.size(); i++) {
            List<Product> products = retrieveAndOrderProductByMetric(metricWeights, productMetrics, i);
            result.addAll(products);
        }
        return result.stream().distinct().collect(Collectors.toList());
    }

    private List<Product> retrieveAndOrderProductByMetric(final List<Double> metricWeights, final List<MetricEntity> productMetrics, final int i) {
        double weight = metricWeights.get(i);
        MetricEntity metricEntity = productMetrics.get(i);
        List<ProductEntity> productEntities = buildQueryByMetric(metricEntity.getClass());
        long limit = getLimit(weight, productEntities);
        return productEntities.stream()
                              .sorted(
                                  Comparator.<ProductEntity>comparingLong(p -> p.getMetrics()
                                                                                .stream()
                                                                                .filter(m -> m.getClass().equals(metricEntity.getClass()))
                                                                                .map(MetricEntity::getMetricValue).findFirst().orElse(0L)).reversed())
                              .limit(limit)
                              .map(mapper::toProduct)
                              .collect(Collectors.toList());
    }

    private long getLimit(final double weight, final List<ProductEntity> productEntities) {
        Double limit = productEntities.size() * weight;
        if (Math.round(limit) > limit) {
            limit = Math.ceil(productEntities.size() * weight);
        } else {
            limit = Math.floor(productEntities.size() * weight);
        }
        return limit.longValue();
    }

    private List<ProductEntity> buildQueryByMetric(Class<? extends MetricEntity> metric) {
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<ProductEntity> query = criteriaBuilder.createQuery(ProductEntity.class);
        Root<ProductEntity> root = query.from(ProductEntity.class);
        Join<ProductEntity, MetricEntity> joinList = root.join("metrics");
        query.where(criteriaBuilder.equal(joinList.type(), metric));
        query.select(root);
        return entityManager.createQuery(query).getResultList();
    }
}
