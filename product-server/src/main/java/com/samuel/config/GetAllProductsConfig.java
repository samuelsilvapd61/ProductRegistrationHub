package com.samuel.config;

import com.samuel.core.usecase.impl.GetAllProductsUseCaseImpl;
import com.samuel.dataprovider.GetAllProductsImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class GetAllProductsConfig {

    @Bean
    public GetAllProductsUseCaseImpl getAllProductsUseCase(GetAllProductsImpl getAllProductsImpl) {
        return new GetAllProductsUseCaseImpl(getAllProductsImpl);
    }

}
