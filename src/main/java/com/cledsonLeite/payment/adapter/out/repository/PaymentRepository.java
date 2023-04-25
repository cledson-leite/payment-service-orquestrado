package com.cledsonLeite.payment.adapter.out.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cledsonLeite.payment.adapter.out.repository.entity.PaymentEntity;

public interface PaymentRepository extends JpaRepository<PaymentEntity, Integer>{

}
