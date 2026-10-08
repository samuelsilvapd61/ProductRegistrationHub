package com.samuel.dataprovider.repository.mapper;

import com.samuel.core.domain.Product;
import com.samuel.dataprovider.repository.entities.ProductEntity;

public class ProductEntityMapper {

    public static ProductEntity toProductEntity(Product product) {
        return ProductEntity.builder()
                .id(product.getId())
                .name(product.getName())
                .description(product.getDescription())
                .price(product.getPrice())
                .build();
    }

    public static Product toProduct(ProductEntity productEntity) {
        return new Product(
                productEntity.getId(),
                productEntity.getName(),
                productEntity.getDescription(),
                productEntity.getPrice()
        );
    }

}
