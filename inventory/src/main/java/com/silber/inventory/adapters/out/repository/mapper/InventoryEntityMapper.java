package com.silber.inventory.adapters.out.repository.mapper;

import com.silber.inventory.adapters.out.repository.InventoryRepository;
import com.silber.inventory.adapters.out.repository.entity.InventoryEntity;
import com.silber.inventory.application.core.domain.Inventory;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface InventoryEntityMapper {

    Inventory toInventory(InventoryEntity inventoryEntity);

    InventoryEntity toInventoryEntity(Inventory inventory);
}
