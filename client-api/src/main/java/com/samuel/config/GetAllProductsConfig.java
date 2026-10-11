package com.samuel.config;

import com.samuel.core.usecase.impl.GetAllProductsUseCaseImpl;
import com.samuel.dataprovider.grpc.GetAllProductsProviderGrpcImpl;
import com.samuel.dataprovider.rest.GetAllProductsProviderImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class GetAllProductsConfig {

    @Bean
    public GetAllProductsUseCaseImpl getAllProductsUseCaseImplRest(GetAllProductsProviderImpl provider) {
        return new GetAllProductsUseCaseImpl(provider);
    }

    @Bean
    public GetAllProductsUseCaseImpl getAllProductsUseCaseImplGrpc(GetAllProductsProviderGrpcImpl provider) {
        return new GetAllProductsUseCaseImpl(provider);
    }

}
