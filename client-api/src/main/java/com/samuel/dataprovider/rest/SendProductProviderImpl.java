package com.samuel.dataprovider.rest;

import com.samuel.core.dataprovider.SendProductProvider;
import com.samuel.core.domain.Product;
import com.samuel.dataprovider.rest.client.ProductServerRestClient;
import com.samuel.dataprovider.rest.request.SendProductRestRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

import static com.samuel.dataprovider.rest.mapper.ProductRestClientMapper.toProduct;

@Component
public class SendProductProviderImpl implements SendProductProvider {

    @Autowired
    private ProductServerRestClient productServerRestClient;

    @Override
    public Product send(String name, String description, BigDecimal price) {

        var productRequest = SendProductRestRequest.builder()
                .name(name)
                .description(description)
                .price(price)
                .build();

        var response = productServerRestClient.send(productRequest);

        return toProduct(response);
    }


}
