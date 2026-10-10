package com.samuel.dataprovider.client.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;

@Data
@Builder
@AllArgsConstructor
public class SendProductRestResponse {

    private String id;
    private String name;
    private String description;
    private BigDecimal price;

}
