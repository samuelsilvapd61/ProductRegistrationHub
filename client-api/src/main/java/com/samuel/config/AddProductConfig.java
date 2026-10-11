package com.samuel.config;

import com.samuel.core.usecase.impl.AddProductUseCaseImpl;
import com.samuel.dataprovider.grpc.SendProductProviderGrpcImpl;
import com.samuel.dataprovider.rest.SendProductProviderImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AddProductConfig {

    @Bean
    public AddProductUseCaseImpl addProductUseCaseImplRest(SendProductProviderImpl provider) {
        return new AddProductUseCaseImpl(provider);
    }

    @Bean
    public AddProductUseCaseImpl addProductUseCaseImplGrpc(SendProductProviderGrpcImpl provider) {
        return new AddProductUseCaseImpl(provider);
    }

}
