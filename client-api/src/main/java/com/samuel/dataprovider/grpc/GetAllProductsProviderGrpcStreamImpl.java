package com.samuel.dataprovider.grpc;

import com.samuel.core.dataprovider.GetAllProductsProvider;
import com.samuel.core.domain.Product;
import com.samuel.dataprovider.grpc.client.ProductServerGrpcClient;
import com.samuel.dataprovider.grpc.mapper.ProductGrpcMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Slf4j
@Component
public class GetAllProductsProviderGrpcStreamImpl implements GetAllProductsProvider {

    @Autowired
    private ProductServerGrpcClient productServerGrpcClient;

    @Override
    public List<Product> getAll() {
        log.info("Getting all products using gRPC Stream");
        var response = productServerGrpcClient.getAllStream();
        var productsProtoList = response.getProductsList();

        return productsProtoList.stream().map(ProductGrpcMapper::protoToProduct).toList();
    }


}
