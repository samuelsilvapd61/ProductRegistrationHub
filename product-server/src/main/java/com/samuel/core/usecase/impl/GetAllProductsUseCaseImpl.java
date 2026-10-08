package com.samuel.core.usecase.impl;

import com.samuel.core.dataprovider.GetAllProducts;
import com.samuel.core.domain.Product;
import com.samuel.core.usecase.GetAllProductsUseCase;

import java.util.List;

public class GetAllProductsUseCaseImpl implements GetAllProductsUseCase {

    private final GetAllProducts getAllProducts;

    public GetAllProductsUseCaseImpl(GetAllProducts getAllProducts) {
        this.getAllProducts = getAllProducts;
    }

    @Override
    public List<Product> getAll() {
        return getAllProducts.getAll();
    }

}
