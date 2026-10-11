package com.samuel.entrypoint.rest;

import com.samuel.core.usecase.AddProductUseCase;
import com.samuel.core.usecase.GetAllProductsUseCase;
import com.samuel.entrypoint.rest.mapper.ProductMapper;
import com.samuel.entrypoint.rest.response.ProductResponse;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/grpc")
public class GrpcRequestResource extends BaseResource {

    private final GetAllProductsUseCase getAllProductsUseCaseStream;

    public GrpcRequestResource(
            @Qualifier("addProductUseCaseImplGrpc") AddProductUseCase addProductUseCase,
            @Qualifier("getAllProductsUseCaseImplGrpc") GetAllProductsUseCase getAllProductsUseCase,
            @Qualifier("getAllProductsUseCaseImplGrpcStream") GetAllProductsUseCase getAllProductsUseCaseStream) {
        this.addProductUseCase = addProductUseCase;
        this.getAllProductsUseCase = getAllProductsUseCase;
        this.getAllProductsUseCaseStream = getAllProductsUseCaseStream;
    }

    @GetMapping("/stream")
    public ResponseEntity<List<ProductResponse>> getAllStream() {
        var productList = getAllProductsUseCaseStream.getAll();
        var response = productList.stream().map(ProductMapper::productToProductResponse).toList();
        return ResponseEntity.ok(response);
    }

}
