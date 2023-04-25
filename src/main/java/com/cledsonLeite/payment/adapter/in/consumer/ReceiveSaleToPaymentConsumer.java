package com.cledsonLeite.payment.adapter.in.consumer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import com.cledsonLeite.payment.adapter.out.message.SaleMessage;
import com.cledsonLeite.payment.application.core.domain.enums.SaleEvent;
import com.cledsonLeite.payment.application.ports.in.PaymentSaleInputPort;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
public class ReceiveSaleToPaymentConsumer {
	
	@Autowired
	PaymentSaleInputPort paymentInputPort;
	
	@KafkaListener(topics = "topic-saga-sale", groupId = "payment")
	public void receive(SaleMessage message) {
		if(SaleEvent.UPDATE_INVENTURY.equals(message.getEvent())) {
			log.info("Iniciando pagamento ...");
			paymentInputPort.payment(message.getSale());
			log.info("Pagamento finalizado com sucesso");
		}
	}
}
