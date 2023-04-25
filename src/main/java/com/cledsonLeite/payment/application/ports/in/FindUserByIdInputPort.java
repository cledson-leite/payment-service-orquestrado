package com.cledsonLeite.payment.application.ports.in;

import com.cledsonLeite.payment.application.core.domain.User;

public interface FindUserByIdInputPort {
	 User find(final Integer id);
}
