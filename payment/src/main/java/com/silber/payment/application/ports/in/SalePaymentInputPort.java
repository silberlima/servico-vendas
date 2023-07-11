package com.silber.payment.application.ports.in;

import com.silber.payment.application.core.domain.Sale;

public interface SalePaymentInputPort {
    void payment(Sale sale);
}
