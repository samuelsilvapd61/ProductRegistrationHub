package com.samuel.core.usecase.impl;

import com.samuel.core.dataprovider.GetAllProductsProvider;
import com.samuel.core.domain.Product;
import com.samuel.core.usecase.GetAllProductsUseCase;

import java.util.List;

public class GetAllProductsUseCaseImpl implements GetAllProductsUseCase {

    private final GetAllProductsProvider getAllProductsProvider;

    public GetAllProductsUseCaseImpl(GetAllProductsProvider getAllProductsProvider) {
        this.getAllProductsProvider = getAllProductsProvider;
    }

    @Override
    public List<Product> getAll() {
        return getAllProductsProvider.getAll();
    }

}
