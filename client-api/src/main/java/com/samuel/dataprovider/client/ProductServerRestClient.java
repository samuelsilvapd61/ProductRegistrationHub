package com.samuel.dataprovider.client;

import com.samuel.dataprovider.client.request.SendProductRestRequest;
import com.samuel.dataprovider.client.response.ProductRestResponse;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;

import java.util.List;

@Service
public class ProductServerRestClient {

    private static final String PRODUCT_URI = "/products";

    private final RestClient restClient;

    public ProductServerRestClient(
            RestClient.Builder builder,
            @Value("${clients.product-server.rest.base-url}") String baseUrl
    ) {
        this.restClient = builder
                .baseUrl(baseUrl)
                .build();
    }

    public ProductRestResponse send(SendProductRestRequest request) {
        return restClient.post()
                .uri(PRODUCT_URI)
                .body(request)
                .retrieve()
                .body(ProductRestResponse.class);
    }

    public List<ProductRestResponse> getAll() {
        return restClient.get()
                .uri(PRODUCT_URI)
                .retrieve()
                .body(new ParameterizedTypeReference<>() {});
    }
}
