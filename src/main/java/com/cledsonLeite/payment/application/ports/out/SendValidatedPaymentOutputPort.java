package com.cledsonLeite.payment.application.ports.out;

import com.cledsonLeite.payment.application.core.domain.Sale;
import com.cledsonLeite.payment.application.core.domain.enums.SaleEvent;

public interface SendValidatedPaymentOutputPort {
	
	public void send(Sale sale, SaleEvent event);

}
