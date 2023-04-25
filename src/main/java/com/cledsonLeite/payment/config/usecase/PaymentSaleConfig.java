package com.cledsonLeite.payment.config.usecase;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.cledsonLeite.payment.adapter.out.SavePaymentAdapter;
import com.cledsonLeite.payment.adapter.out.SendValidatedPaymentAdapter;
import com.cledsonLeite.payment.adapter.out.UpdateUserAdapter;
import com.cledsonLeite.payment.application.core.usecase.FindUserByIdUsecase;
import com.cledsonLeite.payment.application.core.usecase.PaymentSaleUsecase;

@Configuration
public class PaymentSaleConfig {

	@Bean
	public PaymentSaleUsecase paymentSaleUsecase(FindUserByIdUsecase findUserByIdUsecase,
			UpdateUserAdapter updateUserAdapter, SavePaymentAdapter savePaymentAdapter,
			SendValidatedPaymentAdapter sendValidatedPaymentAdapter) {
		return new PaymentSaleUsecase(findUserByIdUsecase, updateUserAdapter, savePaymentAdapter,
				sendValidatedPaymentAdapter);
	}
}
