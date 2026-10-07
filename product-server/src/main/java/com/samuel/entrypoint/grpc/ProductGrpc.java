package com.samuel.entrypoint.grpc;

import com.google.protobuf.Empty;
import com.samuel.productregistrationhub.proto.*;
import io.grpc.stub.StreamObserver;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
class ProductGrpc extends ProductServiceGrpc.ProductServiceImplBase {

    @Override
    public void createProduct(CreateProductRequest request, StreamObserver<ProductResponse> responseObserver) {

        log.info("createProduct {}", request);
        super.createProduct(request, responseObserver);
    }

    @Override
    public void getProduct(GetProductRequest request, StreamObserver<ProductResponse> responseObserver) {
        super.getProduct(request, responseObserver);
    }

    @Override
    public void getProducts(Empty request, StreamObserver<GetProductsResponse> responseObserver) {
        super.getProducts(request, responseObserver);
    }

    @Override
    public void streamGetProducts(Empty request, StreamObserver<Product> responseObserver) {
        super.streamGetProducts(request, responseObserver);
    }

}
