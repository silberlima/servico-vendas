package com.silber.inventory.config.usecase;

import com.silber.inventory.adapters.out.SendUpdateInventoryAdapter;
import com.silber.inventory.adapters.out.UpdateInventoryAdapter;
import com.silber.inventory.application.core.usecase.DebitInventoryUseCase;
import com.silber.inventory.application.core.usecase.FindInventoryByProductIdUseCase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DebitInvetoryConfig {

    @Bean
    public DebitInventoryUseCase debitInventoryUseCase(
            FindInventoryByProductIdUseCase findInventoryByProductIdUseCase,
            UpdateInventoryAdapter updateInventoryAdapter,
            SendUpdateInventoryAdapter sendUpdateInventoryAdapter
    ){
        return new DebitInventoryUseCase(findInventoryByProductIdUseCase, updateInventoryAdapter, sendUpdateInventoryAdapter);
    }
}
