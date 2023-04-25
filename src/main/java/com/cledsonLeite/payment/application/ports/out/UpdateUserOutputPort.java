package com.cledsonLeite.payment.application.ports.out;

import com.cledsonLeite.payment.application.core.domain.User;

public interface UpdateUserOutputPort {
	
	void update(User user);

}
