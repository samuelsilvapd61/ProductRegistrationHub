package com.samuel.entrypoint.rest;


import com.samuel.core.usecase.AddProductUseCase;
import com.samuel.core.usecase.GetAllProductsUseCase;
import com.samuel.core.usecase.GetProductUseCase;
import com.samuel.entrypoint.rest.mapper.ProductMapper;
import com.samuel.entrypoint.rest.reponse.ProductResponse;
import com.samuel.entrypoint.rest.request.ProductRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.samuel.entrypoint.rest.mapper.ProductMapper.toProductResponse;

@RestController
@RequestMapping("/products")
public class ProductResource {

    @Autowired
    private AddProductUseCase addProductUseCase;

    @Autowired
    private GetAllProductsUseCase getAllProductsUseCase;

    @Autowired
    private GetProductUseCase getProductUseCase;

    @PostMapping
    public ResponseEntity<ProductResponse> addProduct(@RequestBody ProductRequest request) {

        var newProduct = addProductUseCase.add(
                request.getName(),
                request.getDescription(),
                request.getPrice()
        );

        var response = toProductResponse(newProduct);
        return ResponseEntity.created(null).body(response);

    }

    @GetMapping
    public ResponseEntity<List<ProductResponse>> getAllProducts() {
        var response = getAllProductsUseCase.getAll().stream().map(ProductMapper::toProductResponse).toList();
        return ResponseEntity.ok(response);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProductResponse> getProductById(@PathVariable String id) {
        var product = getProductUseCase.get(id);
        var response = toProductResponse(product);
        return ResponseEntity.ok(response);
    }

}

