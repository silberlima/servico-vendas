package com.silber.vendas.adapters.out.repository.mapper;

import com.silber.vendas.adapters.out.repository.entity.SaleEntity;
import com.silber.vendas.application.core.domain.Sale;
import com.silber.vendas.application.core.domain.enums.SaleStatus;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;

@Mapper(componentModel = "spring")
public interface SaleEntityMapper {

    @Mapping(source = "status", target = "statusId", qualifiedByName = "setStatusId")
    SaleEntity toSaleEntity(Sale sale);

    @Named("setStatusId")
    default Integer setStatusId(SaleStatus saleStatus){
        return  saleStatus.getStatusId();
    }

    @Mapping(source = "statusId", target = "status", qualifiedByName = "setStatus")
    Sale toSale(SaleEntity saleEntity);

    @Named("setStatus")
    default SaleStatus setStatus(Integer saleStatusId){
        return  SaleStatus.toEnum(saleStatusId);
    }
}
