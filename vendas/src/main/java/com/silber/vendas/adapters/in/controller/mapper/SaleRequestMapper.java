package com.silber.vendas.adapters.in.controller.mapper;

import com.silber.vendas.adapters.in.controller.request.SaleRequest;
import com.silber.vendas.application.core.domain.Sale;
import jakarta.validation.Valid;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface SaleRequestMapper {

    Sale toSale(@Valid SaleRequest saleRequest);
}
