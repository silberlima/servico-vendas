package com.silber.vendas.application.core.usecase;

import com.silber.vendas.application.core.domain.Sale;
import com.silber.vendas.application.ports.out.FindSaleByIdOutputPort;

public class FindSaleByIdUseCase {

    private final FindSaleByIdOutputPort findSaleByIdOutputPort;

    public FindSaleByIdUseCase(FindSaleByIdOutputPort findSaleByIdOutputPort
                               ) {
        this.findSaleByIdOutputPort = findSaleByIdOutputPort;
    }

    public Sale find(final Integer id){
        return findSaleByIdOutputPort.find(id)
                .orElseThrow(()-> new RuntimeException("Venda não encontrada"));
    }
}
