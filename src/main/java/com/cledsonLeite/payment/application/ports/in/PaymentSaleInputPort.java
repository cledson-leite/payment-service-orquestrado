package com.cledsonLeite.payment.application.ports.in;

import com.cledsonLeite.payment.application.core.domain.Sale;

public interface PaymentSaleInputPort {
	void payment(Sale sale);
}
