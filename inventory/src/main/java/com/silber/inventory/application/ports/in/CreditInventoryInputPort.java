package com.silber.inventory.application.ports.in;

import com.silber.inventory.application.core.domain.Sale;

public interface CreditInventoryInputPort {

    void credit(Sale sale);
}
