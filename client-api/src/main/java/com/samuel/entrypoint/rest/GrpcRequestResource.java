package com.samuel.entrypoint.rest;

import com.samuel.core.usecase.AddProductUseCase;
import com.samuel.core.usecase.GetAllProductsUseCase;
import com.samuel.entrypoint.rest.response.ProductResponse;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/grpc")
public class GrpcRequestResource extends BaseResource {

    public GrpcRequestResource(
            @Qualifier("addProductUseCaseImplGrpc") AddProductUseCase addProductUseCase,
            GetAllProductsUseCase getAllProductsUseCase) {
        this.addProductUseCase = addProductUseCase;
        this.getAllProductsUseCase = getAllProductsUseCase;
    }

    @Override
    public ResponseEntity<List<ProductResponse>> getAll() {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}
