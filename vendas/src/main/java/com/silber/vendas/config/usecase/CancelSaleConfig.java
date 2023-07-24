package com.silber.vendas.config.usecase;

import com.silber.vendas.adapters.out.SaveSaleAdapter;
import com.silber.vendas.application.core.usecase.CancelSaleUseCase;
import com.silber.vendas.application.core.usecase.FindSaleByIdUseCase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CancelSaleConfig {

    @Bean
    public CancelSaleUseCase cancelSaleUseCase(FindSaleByIdUseCase findSaleByIdUseCase,
                                               SaveSaleAdapter saveSaleAdapter){
        return  new CancelSaleUseCase(findSaleByIdUseCase, saveSaleAdapter);
    }
}
