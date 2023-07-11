package com.silber.payment.adapters.out;

import com.silber.payment.adapters.out.repository.PaymentRepository;
import com.silber.payment.adapters.out.repository.mapper.PaymentEntityMapper;
import com.silber.payment.application.core.domain.Payment;
import com.silber.payment.application.ports.out.SavePaymentOutuputPort;
import org.springframework.beans.factory.annotation.Autowired;

public class SavePaymentAdapter implements SavePaymentOutuputPort {
    @Autowired
    private PaymentRepository paymentRepository;

    @Autowired
    private PaymentEntityMapper paymentEntityMapper;

    @Override
    public void save(Payment payment) {
        var paymentEntity = paymentEntityMapper.toPaymentEntity(payment);
        paymentRepository.save(paymentEntity);
    }
}
