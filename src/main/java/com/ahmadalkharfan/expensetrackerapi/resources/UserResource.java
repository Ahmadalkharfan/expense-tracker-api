package com.ahmadalkharfan.expensetrackerapi.resources;

import java.util.Map;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/users")
public class UserResource {
	
	@PostMapping("/register")
	public String registerUserString(@RequestBody Map<String, Object> userMap) {
		String firstName = (String) userMap.get("firstName");
		String lastName = (String) userMap.get("lastName");
		String email = (String) userMap.get("email");
		String password = (String) userMap.get("password");
		
		return firstName + ", " + lastName + ", " + email + ", " + password;
	}

}
