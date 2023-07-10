package com.silber.inventory.adapters.out;

import com.silber.inventory.adapters.out.message.SaleMessage;
import com.silber.inventory.application.core.domain.Sale;
import com.silber.inventory.application.core.domain.enums.SaleEvent;
import com.silber.inventory.application.ports.out.SendUpdateInventoryOutputPort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

@Component
public class SendUpdateInventoryAdapter implements SendUpdateInventoryOutputPort {
    @Autowired
    private KafkaTemplate<String, SaleMessage> kafkaTemplate;
    @Override
    public void send(Sale sale, SaleEvent saleEvent) {
        var saleMessage = new SaleMessage(sale, saleEvent);
        kafkaTemplate.send("tp-saga-sale", saleMessage);
    }
}
