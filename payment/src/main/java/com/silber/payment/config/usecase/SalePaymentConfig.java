package com.silber.payment.config.usecase;

import com.silber.payment.adapters.out.SavePaymentAdapter;
import com.silber.payment.adapters.out.SendToKafkaAdapter;
import com.silber.payment.adapters.out.UpdateUserAdapter;
import com.silber.payment.application.core.usecase.FindUserByIdUseCase;
import com.silber.payment.application.core.usecase.SalePaymentUserCase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SalePaymentConfig {

    @Bean
    public SalePaymentUserCase salePaymentUseCase(
            FindUserByIdUseCase findUserByIdUseCase,
            UpdateUserAdapter updateUserAdapter,
            SavePaymentAdapter savePaymentAdapter,
            SendToKafkaAdapter sendToKafkaAdapter
    ){
        return new SalePaymentUserCase(findUserByIdUseCase,
                    updateUserAdapter,
                    savePaymentAdapter,
                    sendToKafkaAdapter);

    }
}



