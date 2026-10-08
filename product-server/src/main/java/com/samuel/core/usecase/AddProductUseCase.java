package com.samuel.core.usecase;

import com.samuel.core.domain.Product;

import java.math.BigDecimal;

public interface AddProductUseCase {

    Product add(String name, String description, BigDecimal price);

}
