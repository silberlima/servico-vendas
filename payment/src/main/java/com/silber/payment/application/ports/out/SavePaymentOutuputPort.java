package com.silber.payment.application.ports.out;

import com.silber.payment.application.core.domain.Payment;

public interface SavePaymentOutuputPort {

    void save(Payment payment);
}
