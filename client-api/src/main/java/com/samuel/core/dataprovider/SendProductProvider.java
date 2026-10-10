package com.samuel.core.dataprovider;

import com.samuel.core.domain.Product;

import java.math.BigDecimal;

public interface SendProductProvider {

    Product send(String name, String description, BigDecimal price);

}
