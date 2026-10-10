package com.samuel.config;

import com.samuel.core.usecase.impl.AddProductUseCaseImpl;
import com.samuel.dataprovider.SendProductProviderImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AddProductUseCaseConfig {

    @Bean
    public AddProductUseCaseImpl addProductUseCaseImpl(SendProductProviderImpl sendProductProviderImpl) {
        return new AddProductUseCaseImpl(sendProductProviderImpl);
    }

}
