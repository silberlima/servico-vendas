package com.silber.inventory.application.ports.in;

import com.silber.inventory.application.core.domain.Inventory;

public interface FindInventoryByProductIdInputPort{

    Inventory find(Integer productId);
}
