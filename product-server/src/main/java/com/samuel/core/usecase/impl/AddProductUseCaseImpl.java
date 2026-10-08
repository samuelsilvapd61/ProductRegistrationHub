package com.samuel.core.usecase.impl;

import com.samuel.core.dataprovider.InsertProductProvider;
import com.samuel.core.domain.Product;
import com.samuel.core.usecase.AddProductUseCase;

import java.math.BigDecimal;
import java.util.UUID;

public class AddProductUseCaseImpl implements AddProductUseCase {

    private final InsertProductProvider insertProductProvider;

    public AddProductUseCaseImpl(InsertProductProvider insertProductProvider) {
        this.insertProductProvider = insertProductProvider;
    }

    @Override
    public Product add(String name, String description, BigDecimal price) {

        var id = UUID.randomUUID().toString();
        var newProduct = new Product(id, name, description, price);

        return insertProductProvider.insert(newProduct);

    }

}
