package com.samuel.core.usecase.impl;

import com.samuel.core.dataprovider.SendProductProvider;
import com.samuel.core.domain.Product;
import com.samuel.core.usecase.AddProductUseCase;

import java.math.BigDecimal;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

public class AddProductUseCaseImpl implements AddProductUseCase {

    private final SendProductProvider sendProductProvider;

    public AddProductUseCaseImpl(SendProductProvider sendProductProvider) {
        this.sendProductProvider = sendProductProvider;
    }

    private record ProductRequest(String name, String description, BigDecimal price) {}

    @Override
    public Product add() {
        var product1 = new ProductRequest("Laptop", "Laptop for work", new BigDecimal("3500.00"));
        var product2 = new ProductRequest("Mouse", "Wireless mouse", new BigDecimal("120.00"));
        var product3 = new ProductRequest("Keyboard", "Mechanical keyboard", new BigDecimal("280.00"));

        var products = List.of(product1, product2, product3);
        var selectedProduct = products.get(ThreadLocalRandom.current().nextInt(products.size()));

        return sendProductProvider.send(selectedProduct.name, selectedProduct.description, selectedProduct.price);
    }

}
