package com.silber.vendas.application.ports.out;

import com.silber.vendas.application.core.domain.Sale;

import java.util.Optional;

public interface FindSaleByIdOutputPort {

    Optional<Sale> find(final Integer id);
}
