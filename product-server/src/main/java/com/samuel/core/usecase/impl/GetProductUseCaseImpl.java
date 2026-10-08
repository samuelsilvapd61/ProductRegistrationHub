package com.samuel.core.usecase.impl;

import com.samuel.core.dataprovider.GetProductByIdProvider;
import com.samuel.core.domain.Product;
import com.samuel.core.usecase.GetProductUseCase;
import com.samuel.exception.ProductNotFoundException;

public class GetProductUseCaseImpl implements GetProductUseCase {

    private final GetProductByIdProvider getProductByIdProvider;

    public GetProductUseCaseImpl(GetProductByIdProvider getProductByIdProvider) {
        this.getProductByIdProvider = getProductByIdProvider;
    }

    @Override
    public Product get(String id) {
        var product = getProductByIdProvider.getProductById(id);
        return product.orElseThrow(() -> new ProductNotFoundException(id));
    }

}
