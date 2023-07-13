package com.silber.vendas.config.usecase;

import com.silber.vendas.adapters.out.FindSaleByIdAdapter;
import com.silber.vendas.application.core.usecase.FindSaleByIdUseCase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FindSaleByIdConfig {


    @Bean
    public FindSaleByIdUseCase findSaleByIdUseCase(
            FindSaleByIdAdapter findSaleByIdAdapter){
        return new FindSaleByIdUseCase(findSaleByIdAdapter);
    }
}
