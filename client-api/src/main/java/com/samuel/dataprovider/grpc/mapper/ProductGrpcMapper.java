package com.samuel.dataprovider.grpc.mapper;

import com.samuel.core.domain.Product;

import java.math.BigDecimal;

public class ProductGrpcMapper {

    public static Product protoToProduct(com.samuel.productregistrationhub.proto.Product product) {
        return new Product(
                product.getId(),
                product.getName(),
                product.getDescription(),
                BigDecimal.valueOf(product.getPrice()));
    }

}
