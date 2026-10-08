package com.samuel.entrypoint.rest;


import com.samuel.core.usecase.AddProductUseCase;
import com.samuel.core.usecase.impl.AddProductUseCaseImpl;
import com.samuel.dataprovider.InsertProductImpl;
import com.samuel.dataprovider.repository.ProductRepository;
import com.samuel.entrypoint.rest.reponse.ProductResponse;
import com.samuel.entrypoint.rest.request.ProductRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static com.samuel.entrypoint.rest.mapper.ProductMapper.toProductResponse;

@RestController
@RequestMapping("/products")
public class ProductResource {

    @Autowired
    private AddProductUseCase addProductUseCase;

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
}

