package com.samuel.dataprovider.grpc;

import com.samuel.core.dataprovider.SendProductProvider;
import com.samuel.core.domain.Product;
import com.samuel.dataprovider.grpc.client.ProductServerGrpcClient;
import com.samuel.productregistrationhub.proto.CreateProductRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

import static com.samuel.dataprovider.grpc.mapper.ProductGrpcMapper.protoToProduct;

@Slf4j
@Component
public class SendProductProviderGrpcImpl implements SendProductProvider {

    @Autowired
    private ProductServerGrpcClient productServerGrpcClient;

    @Override
    public Product send(String name, String description, BigDecimal price) {

        log.info("Sending product request using gRPC");

        var request = CreateProductRequest.newBuilder()
                .setName(name)
                .setDescription(description)
                .setPrice(price.doubleValue())
                .build();
        var response = productServerGrpcClient.send(request);
        var productProto = response.getProduct();

        return protoToProduct(productProto);
    }

}
