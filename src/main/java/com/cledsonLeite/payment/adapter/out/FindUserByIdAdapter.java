package com.cledsonLeite.payment.adapter.out;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.cledsonLeite.payment.adapter.out.repository.UserRepository;
import com.cledsonLeite.payment.adapter.out.repository.mapper.UserEntityMapper;
import com.cledsonLeite.payment.application.core.domain.User;
import com.cledsonLeite.payment.application.ports.out.FindUserByIdOutputPort;

@Component
public class FindUserByIdAdapter implements FindUserByIdOutputPort{
	
	@Autowired
	UserRepository repository;
	
	@Autowired
	UserEntityMapper mapper;

	@Override
	public Optional<User> find(Integer id) {
		var entity = repository.findById(id);
		return entity.map(item -> mapper.toUser(item));
	}

}
