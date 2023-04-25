package com.cledsonLeite.payment.adapter.out.repository.mapper;

import org.mapstruct.Mapper;

import com.cledsonLeite.payment.adapter.out.repository.entity.UserEntity;
import com.cledsonLeite.payment.application.core.domain.User;

@Mapper(componentModel = "spring")
public interface UserEntityMapper {
	
	User toUser(UserEntity entity);
	
	UserEntity toEntity(User user);

}
