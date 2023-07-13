package com.silber.vendas.application.ports.in;

import com.silber.vendas.application.core.domain.Sale;

public interface FinalizeSaleInputPort {

    void finalize(Sale sale);
}
