package com.ahmadalkharfan.expensetrackerapi.services;

import java.util.regex.Pattern;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ahmadalkharfan.expensetrackerapi.domain.User;
import com.ahmadalkharfan.expensetrackerapi.exceptions.EtAuthException;
import com.ahmadalkharfan.expensetrackerapi.repositories.UserRepository;

@Service
@Transactional
public class UserServiceImpl implements UserService {

	
	@Autowired
	UserRepository userRepository;
	
	@Override
	public User validUser(String email, String password) throws EtAuthException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public User registerseUser(String firstName, String lastName, String email, String password)
			throws EtAuthException {
		//email rules
		Pattern pattern = Pattern.compile("^(.+)@(.+)$");
		//email case insensitive
		if(email != null) email= email.toLowerCase();
		if(!pattern.matcher(email).matches())
			throw new EtAuthException("Invalid email format");
		
		Integer count = userRepository.getCountByEmail(email);
		if(count > 0)
			throw new EtAuthException("email is linked to an existing account");
		Integer userId = userRepository.create(firstName, lastName, email, password);
		return userRepository.findById(userId);
	}

}
