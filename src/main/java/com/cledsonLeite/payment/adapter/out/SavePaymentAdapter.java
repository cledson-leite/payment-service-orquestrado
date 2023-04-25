package com.cledsonLeite.payment.adapter.out;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.cledsonLeite.payment.adapter.out.repository.PaymentRepository;
import com.cledsonLeite.payment.adapter.out.repository.entity.PaymentEntity;
import com.cledsonLeite.payment.adapter.out.repository.mapper.PaymentEntityMapper;
import com.cledsonLeite.payment.application.core.domain.Payment;
import com.cledsonLeite.payment.application.ports.out.SavePaymentOutputPort;

@Component
public class SavePaymentAdapter implements SavePaymentOutputPort{
	
	@Autowired
	private PaymentRepository repository;
	
	@Autowired
	private PaymentEntityMapper mapper;

	@Override
	public void save(Payment payment) {
		PaymentEntity entity = mapper.toEntity(payment);
		repository.save(entity);
	}

}
