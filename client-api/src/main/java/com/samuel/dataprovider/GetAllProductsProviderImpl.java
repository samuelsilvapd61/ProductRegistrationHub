package com.samuel.dataprovider;

import com.samuel.core.dataprovider.GetAllProductsProvider;
import com.samuel.core.domain.Product;
import com.samuel.dataprovider.client.ProductServerRestClient;
import com.samuel.dataprovider.client.mapper.ProductRestClientMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class GetAllProductsProviderImpl implements GetAllProductsProvider {

    @Autowired
    private ProductServerRestClient productServerRestClient;

    @Override
    public List<Product> getAll() {
        var response = productServerRestClient.getAll();
        return response.stream().map(ProductRestClientMapper::toProduct).toList();
    }
}
