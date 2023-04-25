package com.cledsonLeite.payment.adapter.out;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.cledsonLeite.payment.adapter.out.repository.UserRepository;
import com.cledsonLeite.payment.adapter.out.repository.entity.UserEntity;
import com.cledsonLeite.payment.adapter.out.repository.mapper.UserEntityMapper;
import com.cledsonLeite.payment.application.core.domain.User;
import com.cledsonLeite.payment.application.ports.out.UpdateUserOutputPort;

@Component
public class UpdateUserAdapter implements UpdateUserOutputPort{
	
	@Autowired
	private UserRepository repository;
	
	@Autowired
	private UserEntityMapper mapper;

	@Override
	public void update(User user) {
		UserEntity entity = mapper.toEntity(user);
		repository.save(entity);
	}

}
