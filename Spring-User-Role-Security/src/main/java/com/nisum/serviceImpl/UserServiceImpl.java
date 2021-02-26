package com.nisum.serviceImpl;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nisum.dto.UserRequest;
import com.nisum.dto.UserResponse;
import com.nisum.entity.User;
import com.nisum.exception.UserNotFoundException;
import com.nisum.mapper.DemoUserMapper;
import com.nisum.mapper.DemoUserMapperImpl;
import com.nisum.repository.UserRepository;
import com.nisum.service.UserService;

@Service
public class UserServiceImpl implements UserService {

	Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);

	private static DemoUserMapper mapper = new DemoUserMapperImpl();

	private UserRepository userRepository;

	@Autowired
	public UserServiceImpl(UserRepository userRepository) {
		this.userRepository = userRepository;
	}

	@Override
	public UserResponse createUser(UserRequest userRequest) {
		logger.info("** Inside createUser() **");
		User user = mapper.fromDto(userRequest);
		logger.info("** Inside createUser() Completed**");
		return mapper.toDtoResponse(userRepository.save(user));
	}

	@Override
	public List<UserResponse> getUsers() {
		logger.info("** Inside getUsers() **");
		List<User> userList = userRepository.findAll();
		logger.info("** Inside getUsers() Completed**");
		return mapper.toDtoResponse(userList);
	}

	@Override
	public UserResponse getUserById(Long id) throws UserNotFoundException {
		logger.info("** Inside getUserById() **");
		Optional<User> optionalUser = userRepository.findById(id);
		if (optionalUser.isPresent()) {
			User user = optionalUser.get();
			logger.info("** Inside getUserById() Completed**");
			return mapper.toDtoResponse(user);
		}
		logger.info("** getUserById:: Some Problem Occure **");
		throw new UserNotFoundException("User Id Not Found");
	}

	@Override
	public UserResponse updateUser(UserRequest userRequest, Long id) throws UserNotFoundException {
		logger.info("** Inside updateUser() **");
		Optional<User> optionalUser = userRepository.findById(id);
		if (optionalUser.isPresent()) {
			User user = optionalUser.get();
			User userResponse = mapper.fromDto(userRequest);
			userResponse.setId(user.getId());
			userRepository.save(userResponse);
			logger.info("** Inside updateUser() Completed**");
			return mapper.toDtoResponse(userResponse);
		}
		logger.info("** updateUser:: Some Problem Occure **");
		throw new UserNotFoundException("User Id Not Found");
	}

	@Override
	public void deleteUserById(Long id) throws UserNotFoundException {
		logger.info("** Inside deleteUserById() **");
		Optional<User> optionalUser = userRepository.findById(id);
		if (optionalUser.isPresent()) {
			User user = optionalUser.get();
			userRepository.delete(user);
			logger.info("** Inside deleteUserById() Completed**");
			return;
		}
		logger.info("** deleteUserById:: Some Problem Occure **");
		throw new UserNotFoundException("User Id Not Found");
	}

	@Override
	public UserResponse getUserByUsername(String username) throws UserNotFoundException {
		logger.info("** Inside getUserByUsername() **");
		Optional<User> optionalUser = userRepository.findByUsername(username);
		if (optionalUser.isPresent()) {
			User user = optionalUser.get();
			logger.info("** Inside getUserByUsername() Completed**");
			return mapper.toDtoResponse(user);
		}
		logger.info("** getUserByUsername:: Some Problem Occure **");
		throw new UserNotFoundException("Username Not Found");
	}

}
