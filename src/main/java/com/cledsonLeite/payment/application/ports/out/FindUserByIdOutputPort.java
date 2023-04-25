package com.cledsonLeite.payment.application.ports.out;

import java.util.Optional;

import com.cledsonLeite.payment.application.core.domain.User;

public interface FindUserByIdOutputPort {
	
	Optional<User> find(Integer id);

}
