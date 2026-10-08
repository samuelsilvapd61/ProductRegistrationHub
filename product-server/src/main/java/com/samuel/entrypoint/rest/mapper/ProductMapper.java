package com.samuel.entrypoint.rest.mapper;


import com.samuel.core.domain.Product;
import com.samuel.entrypoint.rest.reponse.ProductResponse;

public class ProductMapper {

    public static ProductResponse toProductResponse(Product product) {

        return ProductResponse.builder()
                .id(product.getId())
                .name(product.getName())
                .description(product.getDescription())
                .price(product.getPrice())
                .build();

    }

}
