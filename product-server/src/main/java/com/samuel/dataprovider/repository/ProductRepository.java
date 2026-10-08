package com.samuel.dataprovider.repository;

import com.samuel.dataprovider.repository.entities.ProductEntity;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;

@Slf4j
@Repository
public class ProductRepository {

    private record ProductData(String name, String description, BigDecimal price){}

    private final Map<String, ProductData> database = new ConcurrentHashMap<>();

    public ProductEntity insert(ProductEntity productEntity) {

        var id = productEntity.getId();
        var productData = new ProductData(
                productEntity.getName(), productEntity.getDescription(), productEntity.getPrice()
        );

        database.put(id, productData);

        return productEntity;

    }

    public ProductEntity findById(String id) {

        var productData = database.get(id);

        return productData == null ? null : new ProductEntity(
                id,
                productData.name(),
                productData.description(),
                productData.price()
        );

    }

    public List<ProductEntity> findAll() {

        return database.entrySet().stream()
                .map(entry -> new ProductEntity(
                        entry.getKey(),
                        entry.getValue().name(),
                        entry.getValue().description(),
                        entry.getValue().price()
                ))
                .toList();
    }

}
