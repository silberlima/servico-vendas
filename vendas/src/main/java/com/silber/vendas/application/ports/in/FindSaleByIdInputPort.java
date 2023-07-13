package com.silber.vendas.application.ports.in;

import com.silber.vendas.application.core.domain.Sale;

public interface FindSaleByIdInputPort {

    Sale find(final Integer id);
}
