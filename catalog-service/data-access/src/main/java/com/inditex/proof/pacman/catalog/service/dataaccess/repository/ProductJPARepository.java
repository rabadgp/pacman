package com.inditex.proof.pacman.catalog.service.dataaccess.repository;

import com.inditex.proof.pacman.catalog.service.dataaccess.entity.ProductEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductJPARepository extends JpaRepository<ProductEntity, Long> {
}
