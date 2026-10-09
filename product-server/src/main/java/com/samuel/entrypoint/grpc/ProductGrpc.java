package com.samuel.entrypoint.grpc;

import com.google.protobuf.Empty;
import com.samuel.core.usecase.AddProductUseCase;
import com.samuel.core.usecase.GetAllProductsUseCase;
import com.samuel.core.usecase.GetProductUseCase;
import com.samuel.entrypoint.grpc.mapper.ProductToProtoMapper;
import com.samuel.productregistrationhub.proto.*;
import io.grpc.stub.StreamObserver;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

import static com.samuel.entrypoint.grpc.mapper.ProductToProtoMapper.productToProductResponseProto;

@Slf4j
@Service
class ProductGrpc extends ProductServiceGrpc.ProductServiceImplBase {

    @Autowired
    private AddProductUseCase addProductUseCase;

    @Autowired
    private GetProductUseCase getProductUseCase;

    @Autowired
    private GetAllProductsUseCase getAllProductsUseCase;

    @Override
    public void createProduct(CreateProductRequest request, StreamObserver<ProductResponse> responseObserver) {
        var product = addProductUseCase.add(
                request.getName(),
                request.getDescription(),
                BigDecimal.valueOf(request.getPrice()));

        var response = productToProductResponseProto(product);
        responseObserver.onNext(response);
        responseObserver.onCompleted();
    }

    @Override
    public void getProduct(GetProductRequest request, StreamObserver<ProductResponse> responseObserver) {
        var product = getProductUseCase.get(request.getId());
        var response = productToProductResponseProto(product);
        responseObserver.onNext(response);
        responseObserver.onCompleted();
    }

    @Override
    public void getProducts(Empty request, StreamObserver<GetProductsResponse> responseObserver) {
        var productList = getAllProductsUseCase.getAll();

        var response = GetProductsResponse.newBuilder()
                .addAllProducts(
                        productList.stream().map(ProductToProtoMapper::productToProductProto).toList()
                )
                .build();

        responseObserver.onNext(response);
        responseObserver.onCompleted();
    }

    @Override
    public void streamGetProducts(Empty request, StreamObserver<Product> responseObserver) {
        var productList = getAllProductsUseCase.getAll();

        productList.stream()
                .map(ProductToProtoMapper::productToProductProto)
                .forEach(responseObserver::onNext);

        responseObserver.onCompleted();
    }

}
