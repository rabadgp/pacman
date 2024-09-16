package com.inditex.proof.pacman.catalog.service.domain;

import com.inditex.proof.pacman.catalog.service.domain.entity.Product;
import com.inditex.proof.pacman.catalog.service.domain.entity.TShirt;
import com.inditex.proof.pacman.catalog.service.domain.exceptions.ProductDomainException;
import com.inditex.proof.pacman.catalog.service.domain.value.ProductCategory;

public class ProductFactory {

    public static Product build(final ProductCategory category) {
        if (category == ProductCategory.TSHIRT) {
            return new TShirt();
        }
        throw new ProductDomainException("Product cannot be built because category does not exist");
    }
}
