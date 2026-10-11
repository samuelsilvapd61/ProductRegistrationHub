package com.samuel.entrypoint.rest;

import com.samuel.core.usecase.AddProductUseCase;
import com.samuel.core.usecase.GetAllProductsUseCase;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/rest")
public class RestRequestResource extends BaseResource {

    public RestRequestResource(
            @Qualifier("addProductUseCaseImplRest") AddProductUseCase addProductUseCase,
            GetAllProductsUseCase getAllProductsUseCase) {
        this.addProductUseCase = addProductUseCase;
        this.getAllProductsUseCase = getAllProductsUseCase;
    }

}
