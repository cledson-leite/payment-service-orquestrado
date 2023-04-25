package com.cledsonLeite.payment.config.usecase;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.cledsonLeite.payment.adapter.out.FindUserByIdAdapter;
import com.cledsonLeite.payment.application.core.usecase.FindUserByIdUsecase;

@Configuration
public class FindUserByIdConfig {
	@Bean
	public FindUserByIdUsecase findUserByIdUsecase(FindUserByIdAdapter findUserByIdAdapter) {
		return new FindUserByIdUsecase(findUserByIdAdapter);
	}
}
