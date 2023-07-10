package com.silber.inventory.config.usecase;

import com.silber.inventory.adapters.out.FindInventoryByProductIdAdapter;
import com.silber.inventory.application.core.usecase.FindInventoryByProductIdUseCase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FindInvetoryByProductIdConfig {

    @Bean
    public FindInventoryByProductIdUseCase findInventoryByProductIdUseCase(
            FindInventoryByProductIdAdapter findInventoryByProductIdAdapter
    ){
        return new FindInventoryByProductIdUseCase(findInventoryByProductIdAdapter);
    }
}
