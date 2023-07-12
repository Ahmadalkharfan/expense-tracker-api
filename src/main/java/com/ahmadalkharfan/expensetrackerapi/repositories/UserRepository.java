package com.ahmadalkharfan.expensetrackerapi.repositories;

import com.ahmadalkharfan.expensetrackerapi.domain.User;
import com.ahmadalkharfan.expensetrackerapi.exceptions.EtAuthException;

public interface UserRepository {

	
	Integer create(String firstName, String lastName, String email, String password) throws EtAuthException;
	
	User findByEmailAndPassword(String email, String password) throws EtAuthException;
	
	//check if email is already exist
	Integer getCountByEmail (String email);
	
	User findById (Integer userId);
	
}
