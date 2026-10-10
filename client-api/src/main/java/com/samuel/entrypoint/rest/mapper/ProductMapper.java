package com.samuel.entrypoint.rest.mapper;

import com.samuel.core.domain.Product;
import com.samuel.entrypoint.rest.response.ProductResponse;

public class ProductMapper {

    public static ProductResponse productToProductResponse(Product product) {
        return ProductResponse.builder()
                .id(product.getId())
                .name(product.getName())
                .description(product.getDescription())
                .price(product.getPrice())
                .build();
    }

}
