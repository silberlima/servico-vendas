package com.silber.payment.adapters.out.repository.mapper;

import com.silber.payment.adapters.out.repository.entity.PaymentEntity;
import com.silber.payment.application.core.domain.Payment;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface PaymentEntityMapper {

    Payment toPayment(PaymentEntity paymentEntity);

    PaymentEntity toPaymentEntity(Payment payment);
}
