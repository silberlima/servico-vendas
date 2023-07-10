package com.silber.inventory.adapters.in.consumer;

import com.silber.inventory.adapters.out.message.SaleMessage;
import com.silber.inventory.application.core.domain.enums.SaleEvent;
import com.silber.inventory.application.ports.in.DebitInventoryInputPort;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class ReceiveSaleToDebitInvetoryConsumer {
    @Autowired
    private DebitInventoryInputPort debitInventoryInputPort;
    @KafkaListener(topics = "tp-saga-sale", groupId = "inventory-debit")
    public void receive(SaleMessage saleMessage){
        if(SaleEvent.CREATED_SALE.equals(saleMessage.getSaleEvent())){
            log.info("Inicio da separação de mercadoria");
            debitInventoryInputPort.debit(saleMessage.getSale());
            log.info("Fim da separação de mercadoria");
        }
    }
}
