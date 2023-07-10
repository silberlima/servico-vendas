package com.silber.vendas.application.ports.out;

import com.silber.vendas.application.core.domain.Sale;

public interface SaveSaleOutputPort {

    Sale save(Sale sale);
}
