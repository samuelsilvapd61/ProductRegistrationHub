package com.samuel.dataprovider;

import com.samuel.core.dataprovider.GetAllProducts;
import com.samuel.core.domain.Product;
import com.samuel.dataprovider.repository.ProductRepository;
import com.samuel.dataprovider.repository.mapper.ProductEntityMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class GetAllProductsImpl implements GetAllProducts {

    @Autowired
    private ProductRepository productRepository;

    @Override
    public List<Product> getAll() {

        var entityList = productRepository.findAll();

        return entityList.stream().map(ProductEntityMapper::toProduct).toList();
    }

}
