package com.cledsonLeite.payment.adapter.out;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

import com.cledsonLeite.payment.adapter.out.message.SaleMessage;
import com.cledsonLeite.payment.application.core.domain.Sale;
import com.cledsonLeite.payment.application.core.domain.enums.SaleEvent;
import com.cledsonLeite.payment.application.ports.out.SendValidatedPaymentOutputPort;

@Component
public class SendValidatedPaymentAdapter implements SendValidatedPaymentOutputPort{

	@Autowired
	private KafkaTemplate<String, SaleMessage> template;
	
	@Override
	public void send(Sale sale, SaleEvent event) {
		SaleMessage message = new SaleMessage(sale, event);
		template.send("topic-saga-sale", message);
	}

}
