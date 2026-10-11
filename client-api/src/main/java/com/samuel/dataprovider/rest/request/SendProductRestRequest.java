package com.samuel.dataprovider.rest.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;

@Data
@Builder
@AllArgsConstructor
public class SendProductRestRequest {

    private String name;
    private String description;
    private BigDecimal price;

}
