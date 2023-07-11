package com.silber.payment.adapters.out;

import com.silber.payment.adapters.out.message.SaleMessage;
import com.silber.payment.application.core.domain.Sale;
import com.silber.payment.application.core.domain.enums.SaleEvent;
import com.silber.payment.application.ports.out.SendValidatedPaymentOutputPort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

@Component
public class SendValidatedPaymentAdapter implements SendValidatedPaymentOutputPort {
    @Autowired
    private KafkaTemplate<String, SaleMessage> kafkaTemplate;

    @Override
    public void send(Sale sale, SaleEvent saleEvent) {
        var saleMessage = new SaleMessage(sale, saleEvent);
        kafkaTemplate.send("tp-saga-sale", saleMessage);
    }
}
