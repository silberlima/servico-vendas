package com.silber.vendas.adapters.in.controller.request;

import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.math.BigDecimal;
@Data
public class SaleRequest {

    @NotNull
    private Integer userId;

    @NotNull
    private Integer productId;

    @NotNull
    private Integer quatity;

    @NotNull
    private BigDecimal value;
}
