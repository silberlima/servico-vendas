package com.silber.vendas.adapters.in.consumer;

import com.silber.vendas.adapters.out.message.SaleMessage;
import com.silber.vendas.application.core.domain.enums.SaleEvent;
import com.silber.vendas.application.ports.in.CancelSaleInputPort;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class CancelSaleConsumer {

    @Autowired
    private CancelSaleInputPort cancelSaleInputPort;

    @KafkaListener(topics = "tp-saga-sale", groupId = "sale-cancel")
    public void receive(SaleMessage saleMessage){
        if(SaleEvent.ROLLBACK_INVENTORY.equals(saleMessage.getSaleEvent())){
            log.info("Cancelando venda");
            cancelSaleInputPort.cancel(saleMessage.getSale());
            log.info("Venda cancelada com sucesso");
        }
    }

}
