package com.samuel.dataprovider;

import com.samuel.core.dataprovider.InsertProduct;
import com.samuel.core.domain.Product;
import com.samuel.dataprovider.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import static com.samuel.dataprovider.repository.mapper.ProductEntityMapper.toProduct;
import static com.samuel.dataprovider.repository.mapper.ProductEntityMapper.toProductEntity;

@Component
public class InsertProductImpl implements InsertProduct {

    @Autowired
    private ProductRepository productRepository;

    @Override
    public Product insert(Product product) {

        var productEntity = toProductEntity(product);
        var productEntityAdded = productRepository.insert(productEntity);
        return toProduct(productEntityAdded);



    }

}
