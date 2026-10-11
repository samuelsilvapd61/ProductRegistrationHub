package com.samuel.dataprovider.rest.mapper;

import com.samuel.core.domain.Product;
import com.samuel.dataprovider.rest.response.ProductRestResponse;

public class ProductRestClientMapper {

    public static Product toProduct(ProductRestResponse productResponse) {
        return new Product(
                productResponse.getId(),
                productResponse.getName(),
                productResponse.getDescription(),
                productResponse.getPrice());
    }

}
