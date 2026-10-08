package com.samuel.core.usecase.impl;

import com.samuel.core.dataprovider.InsertProduct;
import com.samuel.core.domain.Product;
import com.samuel.core.usecase.AddProductUseCase;

import java.math.BigDecimal;
import java.util.UUID;

public class AddProductUseCaseImpl implements AddProductUseCase {

    private final InsertProduct insertProduct;

    public AddProductUseCaseImpl(InsertProduct insertProduct) {
        this.insertProduct = insertProduct;
    }

    @Override
    public Product add(String name, String description, BigDecimal price) {

        var id = UUID.randomUUID().toString();
        var newProduct = new Product(id, name, description, price);

        return insertProduct.insert(newProduct);

    }

}
