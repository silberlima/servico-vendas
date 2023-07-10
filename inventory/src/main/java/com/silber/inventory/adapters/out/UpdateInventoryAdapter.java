package com.silber.inventory.adapters.out;

import com.silber.inventory.adapters.out.repository.InventoryRepository;
import com.silber.inventory.adapters.out.repository.mapper.InventoryEntityMapper;
import com.silber.inventory.application.core.domain.Inventory;
import com.silber.inventory.application.ports.out.UpdateInventoryOutputPort;
import org.springframework.beans.factory.annotation.Autowired;

public class UpdateInventoryAdapter implements UpdateInventoryOutputPort {
    @Autowired
    private InventoryRepository inventoryRepository;
    @Autowired
    private InventoryEntityMapper inventoryEntityMapper;
    @Override
    public void update(Inventory inventory) {
        var inventoryEntity = inventoryEntityMapper.toInventoryEntity(inventory);
        inventoryRepository.save(inventoryEntity);
    }
}
