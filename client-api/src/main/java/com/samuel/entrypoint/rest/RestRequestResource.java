package com.samuel.entrypoint.rest;

import com.samuel.core.usecase.AddProductUseCase;
import com.samuel.entrypoint.rest.response.ProductResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static com.samuel.entrypoint.rest.mapper.ProductMapper.productToProductResponse;

@RestController
@RequestMapping("/rest")
public class RestRequestResource {

    @Autowired
    private AddProductUseCase addProductUseCase;

//    @Autowired
//    private GetAllProductsUseCase getAllProductsUseCase;

    @PostMapping
    public ProductResponse add() {
        var product = addProductUseCase.add();
        return productToProductResponse(product);
    }

//    @GetMapping
//    public List<ProductResponse> getAll() {
//        var productList = getAllProductsUseCase.getAll();
//        return productList.stream().map(ProductMapper::productToProductResponse).toList();
//    }

}
