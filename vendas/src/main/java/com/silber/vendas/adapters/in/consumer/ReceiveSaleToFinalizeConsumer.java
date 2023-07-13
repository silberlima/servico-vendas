package com.silber.vendas.adapters.in.consumer;

import com.silber.vendas.adapters.out.message.SaleMessage;
import com.silber.vendas.application.core.domain.enums.SaleEvent;
import com.silber.vendas.application.ports.in.FinalizeSaleInputPort;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class ReceiveSaleToFinalizeConsumer {

    @Autowired
    private FinalizeSaleInputPort finalizeSaleInputPort;

    @KafkaListener(topics = "tp-saga-sale", groupId = "saga-finalize")
    public void receive(SaleMessage saleMessage){
        if(SaleEvent.VALIDATED_PAYMENT.equals(saleMessage.getSaleEvent())){
            log.info("Finalizando a venda");
            finalizeSaleInputPort.finalize(saleMessage.getSale());
            log.info("Venda finalizada com sucesso");
        }


    }
}
