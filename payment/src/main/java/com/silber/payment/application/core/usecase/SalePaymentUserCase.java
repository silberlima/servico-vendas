package com.silber.payment.application.core.usecase;

import com.silber.payment.application.core.domain.Payment;
import com.silber.payment.application.core.domain.Sale;
import com.silber.payment.application.core.domain.enums.SaleEvent;
import com.silber.payment.application.ports.in.FindUserByIdInputPort;
import com.silber.payment.application.ports.in.SalePaymentInputPort;
import com.silber.payment.application.ports.out.SavePaymentOutuputPort;
import com.silber.payment.application.ports.out.SendValidatedPaymentOutputPort;
import com.silber.payment.application.ports.out.UpdateUserOutputPort;

public class SalePaymentUserCase implements SalePaymentInputPort {
    private final FindUserByIdInputPort findUserByIdInputPort;

    private final UpdateUserOutputPort updateUserOutputPort;

    private  final SavePaymentOutuputPort savePaymentOutuputPort;

    private final SendValidatedPaymentOutputPort sendValidatedPaymentOutputPort;

    public SalePaymentUserCase(FindUserByIdInputPort findUserByIdInputPort,
                               UpdateUserOutputPort updateUserOutputPort,
                               SavePaymentOutuputPort savePaymentOutuputPort,
                               SendValidatedPaymentOutputPort sendValidatedPaymentOutputPort) {
        this.findUserByIdInputPort = findUserByIdInputPort;
        this.updateUserOutputPort = updateUserOutputPort;
        this.savePaymentOutuputPort = savePaymentOutuputPort;
        this.sendValidatedPaymentOutputPort = sendValidatedPaymentOutputPort;
    }

    @Override
    public void payment(Sale sale){
        var user = findUserByIdInputPort.find(sale.getUserId());

        if(user.getBalance().compareTo(sale.getValue())<0){
            throw new RuntimeException("Saldo insuficiente");
        }

        user.debitBalance(sale.getValue());
        updateUserOutputPort.update(user);
        savePaymentOutuputPort.save(buildPayment(sale));
        sendValidatedPaymentOutputPort.send(sale, SaleEvent.VALIDATED_PAYMENT);
    }


    private Payment buildPayment(Sale sale){
        return new Payment(null, sale.getUserId(), sale.getId(), sale.getValue());
    }
}
