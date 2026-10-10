package com.samuel.dataprovider.client.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;

@Data
@Builder
@AllArgsConstructor
public class ProductRestResponse {

    private String id;
    private String name;
    private String description;
    private BigDecimal price;

}
