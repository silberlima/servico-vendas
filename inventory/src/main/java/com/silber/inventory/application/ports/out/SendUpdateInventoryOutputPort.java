package com.silber.inventory.application.ports.out;

import com.silber.inventory.application.core.domain.Sale;
import com.silber.inventory.application.core.domain.enums.SaleEvent;

public interface SendUpdateInventoryOutputPort {

    void send(Sale sale, SaleEvent saleEvent);
}
