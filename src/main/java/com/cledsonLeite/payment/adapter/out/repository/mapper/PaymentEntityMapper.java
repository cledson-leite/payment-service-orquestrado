package com.cledsonLeite.payment.adapter.out.repository.mapper;

import org.mapstruct.Mapper;

import com.cledsonLeite.payment.adapter.out.repository.entity.PaymentEntity;
import com.cledsonLeite.payment.application.core.domain.Payment;

@Mapper(componentModel = "spring")
public interface PaymentEntityMapper {
	PaymentEntity toEntity(Payment payment);
}
