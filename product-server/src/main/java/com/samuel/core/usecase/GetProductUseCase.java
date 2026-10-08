package com.samuel.core.usecase;

import com.samuel.core.domain.Product;

public interface GetProductUseCase {

    Product get(String id);

}
