package com.samuel.entrypoint.rest;

import com.samuel.core.usecase.AddProductUseCase;
import com.samuel.core.usecase.GetAllProductsUseCase;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/grpc")
public class GrpcRequestResource extends BaseResource {

    public GrpcRequestResource(
            @Qualifier("addProductUseCaseImplGrpc") AddProductUseCase addProductUseCase,
            @Qualifier("getAllProductsUseCaseImplGrpc") GetAllProductsUseCase getAllProductsUseCase) {
        this.addProductUseCase = addProductUseCase;
        this.getAllProductsUseCase = getAllProductsUseCase;
    }

}
