package com.silber.inventory.application.ports.out;

import com.silber.inventory.application.core.domain.Inventory;

public interface UpdateInventoryOutputPort {

    void update (Inventory inventory);
}
