package com.samuel.entrypoint.grpc.mapper;

import com.samuel.productregistrationhub.proto.Product;
import com.samuel.productregistrationhub.proto.ProductResponse;

public class ProductToProtoMapper {

    public static Product productToProductProto(com.samuel.core.domain.Product product) {
        return Product.newBuilder()
                .setId(product.getId())
                .setName(product.getName())
                .setDescription(product.getDescription())
                .setPrice(product.getPrice().doubleValue())
                .build();
    }

    public static ProductResponse productToProductResponseProto(com.samuel.core.domain.Product product) {
        return ProductResponse.newBuilder()
                .setProduct(productToProductProto(product))
                .build();
    }

}
