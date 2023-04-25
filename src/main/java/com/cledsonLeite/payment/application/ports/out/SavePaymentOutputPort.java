package com.cledsonLeite.payment.application.ports.out;

import com.cledsonLeite.payment.application.core.domain.Payment;

public interface SavePaymentOutputPort {
	
	public void save(Payment payment);

}
