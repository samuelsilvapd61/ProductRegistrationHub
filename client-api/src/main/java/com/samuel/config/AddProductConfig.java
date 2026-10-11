package com.samuel.config;

import com.samuel.core.usecase.impl.AddProductUseCaseImpl;
import com.samuel.dataprovider.grpc.SendProductProviderGrpcImpl;
import com.samuel.dataprovider.rest.SendProductProviderImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AddProductConfig {

    @Bean
    public AddProductUseCaseImpl addProductUseCaseImplRest(SendProductProviderImpl sendProductProviderImpl) {
        return new AddProductUseCaseImpl(sendProductProviderImpl);
    }

    @Bean
    public AddProductUseCaseImpl addProductUseCaseImplGrpc(SendProductProviderGrpcImpl sendProductProviderGrpcImpl) {
        return new AddProductUseCaseImpl(sendProductProviderGrpcImpl);
    }

}
