package com.samuel.config;

import com.samuel.core.usecase.impl.AddProductUseCaseImpl;
import com.samuel.dataprovider.InsertProductProviderImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AddProductConfig {

    @Bean
    public AddProductUseCaseImpl addProductUseCase(InsertProductProviderImpl insertProductProviderImpl) {
        return new AddProductUseCaseImpl(insertProductProviderImpl);
    }

}
