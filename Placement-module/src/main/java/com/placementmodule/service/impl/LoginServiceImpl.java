package com.placementmodule.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.placementmodule.entities.Login;
import com.placementmodule.repository.LoginRepository;

@Service
public class LoginServiceImpl {

	@Autowired
	private LoginRepository repo;
	  
	public Login login(String userName, String password) {
		Login placementOfficer = repo.findByUserNameAndPassword(userName, password);
		return placementOfficer;
	  }
}
