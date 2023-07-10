package com.silber.vendas.application.ports.out;

import com.silber.vendas.application.core.domain.Sale;
import com.silber.vendas.application.core.domain.enums.SaleEvent;

public interface SendCreatedSaleOutputPort {

    void send(Sale sale, SaleEvent event);
}
