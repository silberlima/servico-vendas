package com.silber.vendas.application.core.usecase;

import com.silber.vendas.application.core.domain.Sale;
import com.silber.vendas.application.core.domain.enums.SaleStatus;
import com.silber.vendas.application.ports.in.FindSaleByIdInputPort;
import com.silber.vendas.application.ports.out.SaveSaleOutputPort;

public class FinalizeSaleUseCase {

    private final FindSaleByIdInputPort findSaleByIdInputPort;

    private final SaveSaleOutputPort saveSaleOutputPort;
    public FinalizeSaleUseCase(FindSaleByIdInputPort findSaleByIdInputPort,
                               SaveSaleOutputPort saveSaleOutputPort) {
        this.findSaleByIdInputPort = findSaleByIdInputPort;
        this.saveSaleOutputPort = saveSaleOutputPort;
    }

    public void finalize(Sale sale){
        var saleResponse = findSaleByIdInputPort.find(sale.getId());
        saleResponse.setStatus(SaleStatus.FINALIZED);
        saveSaleOutputPort.save(saleResponse);
    }
}
