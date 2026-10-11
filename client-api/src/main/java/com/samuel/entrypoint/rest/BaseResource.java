package com.samuel.entrypoint.rest;

import com.samuel.core.usecase.AddProductUseCase;
import com.samuel.core.usecase.GetAllProductsUseCase;
import com.samuel.entrypoint.rest.mapper.ProductMapper;
import com.samuel.entrypoint.rest.response.ProductResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

import static com.samuel.entrypoint.rest.mapper.ProductMapper.productToProductResponse;

public abstract class BaseResource {

    protected AddProductUseCase addProductUseCase;
    protected GetAllProductsUseCase getAllProductsUseCase;

    @PostMapping
    public ProductResponse add() {
        var product = addProductUseCase.add();
        return productToProductResponse(product);
    }

    @GetMapping
    public ResponseEntity<List<ProductResponse>> getAll() {
        var productList = getAllProductsUseCase.getAll();
        var response = productList.stream().map(ProductMapper::productToProductResponse).toList();
        return ResponseEntity.ok(response);
    }

}
