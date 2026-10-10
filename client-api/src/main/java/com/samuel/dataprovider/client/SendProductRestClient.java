package com.samuel.dataprovider.client;

import com.samuel.dataprovider.client.request.SendProductRestRequest;
import com.samuel.dataprovider.client.response.SendProductRestResponse;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;

@Service
public class SendProductRestClient {

    private final RestClient restClient;

    public SendProductRestClient(
            RestClient.Builder builder,
            @Value("${clients.product-server.rest.base-url}") String baseUrl
    ) {
        this.restClient = builder
                .baseUrl(baseUrl)
                .build();
    }

    public SendProductRestResponse send(SendProductRestRequest request) {
        return restClient.post()
                .uri("/products")
                .body(request)
                .retrieve()
                .body(SendProductRestResponse.class);
    }
}

