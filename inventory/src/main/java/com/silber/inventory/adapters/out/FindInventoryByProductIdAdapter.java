package com.silber.inventory.adapters.out;

import com.silber.inventory.adapters.out.repository.InventoryRepository;
import com.silber.inventory.adapters.out.repository.mapper.InventoryEntityMapper;
import com.silber.inventory.application.core.domain.Inventory;
import com.silber.inventory.application.ports.out.FindInventoryByProductIdOutputPort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class FindInventoryByProductIdAdapter implements FindInventoryByProductIdOutputPort {

    @Autowired
    private InventoryRepository inventoryRepository;

    @Autowired
    private InventoryEntityMapper inventoryEntityMapper;

    @Override
    public Optional<Inventory> find(Integer productId) {
        var inventoryEntity = inventoryRepository.findByProductId(productId);
        return inventoryEntity.map(inventoryEntityMapper::toInventory);
    }
}
