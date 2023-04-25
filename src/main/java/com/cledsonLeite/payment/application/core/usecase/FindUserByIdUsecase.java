package com.cledsonLeite.payment.application.core.usecase;

import com.cledsonLeite.payment.application.core.domain.User;
import com.cledsonLeite.payment.application.ports.in.FindUserByIdInputPort;
import com.cledsonLeite.payment.application.ports.out.FindUserByIdOutputPort;

public class FindUserByIdUsecase implements FindUserByIdInputPort{

	private FindUserByIdOutputPort findUserByIdOutputPort;

	public FindUserByIdUsecase(FindUserByIdOutputPort findUserByIdOutputPort) {
		super();
		this.findUserByIdOutputPort = findUserByIdOutputPort;
	}

	public User find(final Integer id) {
		return findUserByIdOutputPort.find(id).orElseThrow(() -> new RuntimeException("Usuário não encontrado"));
	}

}
