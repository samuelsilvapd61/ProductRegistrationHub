package com.samuel.dataprovider.repository.entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;

@Data
@Builder
@AllArgsConstructor
public class ProductEntity {

    private String id;
    private String name;
    private String description;
    private BigDecimal price;

}
