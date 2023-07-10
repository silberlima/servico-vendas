package com.silber.inventory.application.core.usecase;

import com.silber.inventory.application.core.domain.Sale;
import com.silber.inventory.application.core.domain.enums.SaleEvent;
import com.silber.inventory.application.ports.in.DebitInventoryInputPort;
import com.silber.inventory.application.ports.in.FindInventoryByProductIdInputPort;
import com.silber.inventory.application.ports.out.SendUpdateInventoryOutputPort;
import com.silber.inventory.application.ports.out.UpdateInventoryOutputPort;

public class DebitInventoryUseCase implements DebitInventoryInputPort {

    private final FindInventoryByProductIdInputPort findInventoryByProductIdInputPort;

    private final UpdateInventoryOutputPort updateInventoryOutputPort;

    private final SendUpdateInventoryOutputPort sendUpdateInventoryOutputPort;


    public DebitInventoryUseCase(
            FindInventoryByProductIdInputPort findInventoryByProductIdInputPort,
            UpdateInventoryOutputPort updateInventoryOutputPort,
            SendUpdateInventoryOutputPort sendUpdateInventoryOutputPort) {
        this.findInventoryByProductIdInputPort = findInventoryByProductIdInputPort;
        this.updateInventoryOutputPort = updateInventoryOutputPort;
        this.sendUpdateInventoryOutputPort = sendUpdateInventoryOutputPort;
    }

     @Override
    public void debit(Sale sale){
        var inventory = findInventoryByProductIdInputPort.find(sale.getProductId());
        if(inventory.getQuantity() < sale.getQuantity()){
            throw new RuntimeException("Estoque insuficiente");
        }

        inventory.debitQuantity(sale.getQuantity());

        updateInventoryOutputPort.update(inventory);
        sendUpdateInventoryOutputPort.send(sale, SaleEvent.UPDATED_INVENTORY);

    }
}
