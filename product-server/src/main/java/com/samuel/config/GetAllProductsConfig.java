package com.samuel.config;

import com.samuel.core.usecase.impl.GetAllProductsUseCaseImpl;
import com.samuel.dataprovider.GetAllProductsProviderImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class GetAllProductsConfig {

    @Bean
    public GetAllProductsUseCaseImpl getAllProductsUseCase(GetAllProductsProviderImpl getAllProductsProviderImpl) {
        return new GetAllProductsUseCaseImpl(getAllProductsProviderImpl);
    }

}
