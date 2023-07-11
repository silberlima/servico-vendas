package com.silber.payment.config.usecase;

import com.silber.payment.adapters.out.FindUserByIdAdapter;
import com.silber.payment.application.core.usecase.FindUserByIdUseCase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FindUserByIdConfig {

    @Bean
    public FindUserByIdUseCase findByIdUserCase(
            FindUserByIdAdapter findUserByIdAdapter){
        return new FindUserByIdUseCase(findUserByIdAdapter);
    }


}
