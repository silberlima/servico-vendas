package com.silber.payment.adapters.out.message;

import com.silber.payment.application.core.domain.Sale;
import com.silber.payment.application.core.domain.enums.SaleEvent;
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
