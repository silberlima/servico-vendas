package com.silber.vendas.application.core.usecase;

import com.silber.vendas.application.core.domain.Sale;
import com.silber.vendas.application.core.domain.enums.SaleEvent;
import com.silber.vendas.application.core.domain.enums.SaleStatus;
import com.silber.vendas.application.ports.in.CreateSaleInputPort;
import com.silber.vendas.application.ports.out.SaveSaleOutputPort;
import com.silber.vendas.application.ports.out.SendCreatedSaleOutputPort;

public class CreateSaleUseCase implements CreateSaleInputPort {

    private final SaveSaleOutputPort saveSaleOutputPort;

    private final SendCreatedSaleOutputPort sendCreatedSaleOutputPort;

    public CreateSaleUseCase(SaveSaleOutputPort saveSaleOutputPort
            , SendCreatedSaleOutputPort sendCreatedSaleOutputPort) {
        this.saveSaleOutputPort = saveSaleOutputPort;
        this.sendCreatedSaleOutputPort = sendCreatedSaleOutputPort;
    }

    @Override
    public void create(Sale sale){
        sale.setStatus(SaleStatus.PENDING);
        var saleResponse = saveSaleOutputPort.save(sale);
        sendCreatedSaleOutputPort.send(saleResponse, SaleEvent.CREATED_SALE);
    }
}
