package com.nisum.mapper;

import java.util.List;

import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.nisum.dto.UserRequest;
import com.nisum.dto.UserResponse;
import com.nisum.entity.User;

@Mapper
public interface DemoUserMapper {
//	@Mapping(source = "username", target = "name")
	UserRequest toDtoRequest(User user);

	UserResponse toDtoResponse(User user);

//	@InheritInverseConfiguration(name = "toDto")
	User fromDto(UserRequest userRequest);

	List<UserRequest> toDtoRequest(List<User> user);

	List<UserResponse> toDtoResponse(List<User> user);

}
