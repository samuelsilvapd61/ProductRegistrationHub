package com.samuel.dataprovider.rest;

import com.samuel.core.dataprovider.SendProductProvider;
import com.samuel.core.domain.Product;
import com.samuel.dataprovider.rest.client.ProductServerRestClient;
import com.samuel.dataprovider.rest.request.SendProductRestRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

import static com.samuel.dataprovider.rest.mapper.ProductRestClientMapper.toProduct;

@Slf4j
@Component
public class SendProductProviderImpl implements SendProductProvider {

    @Autowired
    private ProductServerRestClient productServerRestClient;

    @Override
    public Product send(String name, String description, BigDecimal price) {
        log.info("Sending product request using REST");

        var productRequest = SendProductRestRequest.builder()
                .name(name)
                .description(description)
                .price(price)
                .build();

        var response = productServerRestClient.send(productRequest);

        return toProduct(response);
    }


}
