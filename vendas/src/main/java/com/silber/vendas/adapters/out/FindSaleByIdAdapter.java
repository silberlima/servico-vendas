package com.silber.vendas.adapters.out;

import com.silber.vendas.adapters.out.repository.SaleRepository;
import com.silber.vendas.adapters.out.repository.mapper.SaleEntityMapper;
import com.silber.vendas.application.core.domain.Sale;
import com.silber.vendas.application.ports.out.FindSaleByIdOutputPort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class FindSaleByIdAdapter implements FindSaleByIdOutputPort {

    @Autowired
    private SaleRepository saleRepository;

    @Autowired
    private SaleEntityMapper saleEntityMapper;

    @Override
    public Optional<Sale> find(Integer id) {
        var saleEntity = saleRepository.findById(id);
        return saleEntity.map(saleEntityMapper::toSale);
    }
}
