package com.silber.inventory.application.ports.out;

import com.silber.inventory.application.core.domain.Inventory;

import java.util.Optional;

public interface FindInventoryByProductIdOutputPort {

    Optional<Inventory> find(final Integer productId);
}
