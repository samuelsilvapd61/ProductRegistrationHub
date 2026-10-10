package com.samuel.dataprovider.client.mapper;

import com.samuel.core.domain.Product;
import com.samuel.dataprovider.client.response.SendProductRestResponse;

public class ProductRestClientMapper {

    public static Product toProduct(SendProductRestResponse productResponse) {
        return new Product(
                productResponse.getId(),
                productResponse.getName(),
                productResponse.getDescription(),
                productResponse.getPrice());
    }

}
