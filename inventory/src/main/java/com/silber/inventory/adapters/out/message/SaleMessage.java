package com.silber.inventory.adapters.out.message;

import com.silber.inventory.application.core.domain.Sale;
import com.silber.inventory.application.core.domain.enums.SaleEvent;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SaleMessage {

    private Sale sale;

    private SaleEvent saleEvent;
}
