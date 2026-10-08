package com.samuel.config;

import com.samuel.core.usecase.impl.AddProductUseCaseImpl;
import com.samuel.dataprovider.InsertProductImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class InsertCustomerConfig {

    @Bean
    public AddProductUseCaseImpl addProductUseCase(InsertProductImpl insertProduct) {
        return new AddProductUseCaseImpl(insertProduct);
    }

}
