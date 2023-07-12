package com.ahmadalkharfan.expensetrackerapi.services;

import com.ahmadalkharfan.expensetrackerapi.domain.User;
import com.ahmadalkharfan.expensetrackerapi.exceptions.EtAuthException;

public interface UserService {

	User validUser(String email, String password) throws EtAuthException;

	User registerseUser(String firstName, String lastName, String email, String password) throws EtAuthException;
}
