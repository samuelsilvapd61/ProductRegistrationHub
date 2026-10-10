package com.samuel.dataprovider;

import com.samuel.core.dataprovider.SendProductProvider;
import com.samuel.core.domain.Product;
import com.samuel.dataprovider.client.ProductServerRestClient;
import com.samuel.dataprovider.client.request.SendProductRestRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

import static com.samuel.dataprovider.client.mapper.ProductRestClientMapper.toProduct;

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
