package com.samuel.dataprovider;

import com.samuel.core.dataprovider.GetProductByIdProvider;
import com.samuel.core.domain.Product;
import com.samuel.dataprovider.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class GetProductByIdProviderImpl implements GetProductByIdProvider {

    @Autowired
    private ProductRepository productRepository;

    @Override
    public Optional<Product> getProductById(String id) {

        var productEntity = productRepository.findById(id);

        if (productEntity == null) {
            return Optional.empty();
        }

        var product = new Product(
                productEntity.getId(),
                productEntity.getName(),
                productEntity.getDescription(),
                productEntity.getPrice()
        );

        return Optional.of(product);
    }

}
