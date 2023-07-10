package com.silber.vendas.adapters.out.message;

import com.silber.vendas.application.core.domain.Sale;
import com.silber.vendas.application.core.domain.enums.SaleEvent;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class SaleMessage {

    private Sale sale;

    private SaleEvent saleEvent;
}
