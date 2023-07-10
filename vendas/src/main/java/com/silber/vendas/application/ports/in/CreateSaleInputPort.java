package com.silber.vendas.application.ports.in;

import com.silber.vendas.application.core.domain.Sale;

public interface CreateSaleInputPort {

    void create(Sale sale);
}
