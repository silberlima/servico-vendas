package com.silber.inventory.adapters.in.consumer;

import com.silber.inventory.adapters.out.message.SaleMessage;
import com.silber.inventory.application.core.domain.enums.SaleEvent;
import com.silber.inventory.application.ports.in.CreditInventoryInputPort;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class ReceiveSaleToCreditInventoryConsumer {

    @Autowired
    private CreditInventoryInputPort creditInventoryInputPort;

    @KafkaListener(topics = "tp-saga-sale", groupId = "inventory-credit")
    public void receive(SaleMessage saleMessage){
        if(SaleEvent.FAILED_PAYMENT.equals(saleMessage.getSaleEvent())){
            log.info("Inicio devolução da mercadori");
            creditInventoryInputPort.credit(saleMessage.getSale());
            log.info("Fim devolução mercadoria");
        }
    }
}
