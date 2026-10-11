package com.samuel.dataprovider.grpc.client;

import com.google.protobuf.Empty;
import com.samuel.productregistrationhub.proto.CreateProductRequest;
import com.samuel.productregistrationhub.proto.GetProductsResponse;
import com.samuel.productregistrationhub.proto.ProductResponse;
import com.samuel.productregistrationhub.proto.ProductServiceGrpc.ProductServiceBlockingStub;
import org.springframework.grpc.client.ImportGrpcClients;
import org.springframework.stereotype.Component;

@Component
@ImportGrpcClients(target = "product-server", types = ProductServiceBlockingStub.class)
public class ProductServerGrpcClient {

    private final ProductServiceBlockingStub stub;

    public ProductServerGrpcClient(ProductServiceBlockingStub stub) {
        this.stub = stub;
    }

    public ProductResponse send(CreateProductRequest request) {
        return stub.createProduct(request);
    }

    public GetProductsResponse getAll() {
        return stub.getProducts(Empty.newBuilder().build());
    }

}
