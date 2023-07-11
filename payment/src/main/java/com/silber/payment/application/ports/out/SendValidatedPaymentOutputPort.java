package com.silber.payment.application.ports.out;

import com.silber.payment.application.core.domain.Sale;
import com.silber.payment.application.core.domain.enums.SaleEvent;

public interface SendValidatedPaymentOutputPort {

    void send(Sale sale, SaleEvent saleEvent);
}
