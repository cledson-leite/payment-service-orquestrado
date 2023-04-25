package com.cledsonLeite.payment.application.core.usecase;

import java.math.BigDecimal;

import com.cledsonLeite.payment.application.core.domain.Payment;
import com.cledsonLeite.payment.application.core.domain.Sale;
import com.cledsonLeite.payment.application.core.domain.User;
import com.cledsonLeite.payment.application.core.domain.enums.SaleEvent;
import com.cledsonLeite.payment.application.ports.in.FindUserByIdInputPort;
import com.cledsonLeite.payment.application.ports.in.PaymentSaleInputPort;
import com.cledsonLeite.payment.application.ports.out.SavePaymentOutputPort;
import com.cledsonLeite.payment.application.ports.out.SendValidatedPaymentOutputPort;
import com.cledsonLeite.payment.application.ports.out.UpdateUserOutputPort;

public class PaymentSaleUsecase implements PaymentSaleInputPort{
	
	private final FindUserByIdInputPort findUserByIdInputPort;
	private final UpdateUserOutputPort updateUserOutputPort;
	private final SavePaymentOutputPort savePaymentOutputPort;
	private final SendValidatedPaymentOutputPort sendValidatedPaymentOutputPort;
	
	
	
	public PaymentSaleUsecase(
			FindUserByIdInputPort findUserByIdInputPort,
			UpdateUserOutputPort updateUserOutputPort,
			SavePaymentOutputPort savePaymentOutputPort,
			SendValidatedPaymentOutputPort sendValidatedPaymentOutputPort
			) {
		this.findUserByIdInputPort = findUserByIdInputPort;
		this.updateUserOutputPort = updateUserOutputPort;
		this.savePaymentOutputPort = savePaymentOutputPort;
		this.sendValidatedPaymentOutputPort = sendValidatedPaymentOutputPort;
		
	}



	public void payment(Sale sale) {
		User user = findUserByIdInputPort.find(sale.getId());
		if(user.getBalance().compareTo(sale.getValue()) < 0) {
			throw new RuntimeException("Saldo insuficiente");
		}
		
		BigDecimal currentBalance = user.getBalance().subtract(sale.getValue());
		user.setBalance(currentBalance);
		updateUserOutputPort.update(user);
		Payment payment = new Payment(
				null, 
				sale.getUserId(), 
				sale.getId(),
				sale.getValue()
				);
		savePaymentOutputPort.save(payment);
		sendValidatedPaymentOutputPort.send(sale, SaleEvent.VALIDATED_PAYMENT);
		
	}

}
