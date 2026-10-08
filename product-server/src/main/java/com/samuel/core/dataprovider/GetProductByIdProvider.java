package com.samuel.core.dataprovider;

import com.samuel.core.domain.Product;

import java.util.Optional;

public interface GetProductByIdProvider {

    Optional<Product> getProductById(String id);

}
