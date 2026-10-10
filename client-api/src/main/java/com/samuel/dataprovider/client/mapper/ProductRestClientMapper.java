package com.samuel.dataprovider.client.mapper;

import com.samuel.core.domain.Product;
import com.samuel.dataprovider.client.response.ProductRestResponse;

public class ProductRestClientMapper {

    public static Product toProduct(ProductRestResponse productResponse) {
        return new Product(
                productResponse.getId(),
                productResponse.getName(),
                productResponse.getDescription(),
                productResponse.getPrice());
    }

}
