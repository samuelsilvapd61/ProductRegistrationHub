package com.samuel.dataprovider.rest;

import com.samuel.core.dataprovider.GetAllProductsProvider;
import com.samuel.core.domain.Product;
import com.samuel.dataprovider.rest.client.ProductServerRestClient;
import com.samuel.dataprovider.rest.mapper.ProductRestClientMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Slf4j
@Component
public class GetAllProductsProviderImpl implements GetAllProductsProvider {

    @Autowired
    private ProductServerRestClient productServerRestClient;

    @Override
    public List<Product> getAll() {
        log.info("Getting all products using REST");
        var response = productServerRestClient.getAll();
        return response.stream().map(ProductRestClientMapper::toProduct).toList();
    }
}
