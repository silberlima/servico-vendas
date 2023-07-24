package com.silber.vendas.application.ports.in;

import com.silber.vendas.application.core.domain.Sale;

public interface CancelSaleInputPort {

    void cancel(Sale sale);
}
