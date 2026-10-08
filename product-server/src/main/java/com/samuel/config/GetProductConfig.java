package com.samuel.config;

import com.samuel.core.usecase.impl.GetProductUseCaseImpl;
import com.samuel.dataprovider.GetProductByIdProviderImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class GetProductConfig {

    @Bean
    public GetProductUseCaseImpl getProductUseCase(GetProductByIdProviderImpl getProductByIdProvider) {
        return new GetProductUseCaseImpl(getProductByIdProvider);
    }

}
