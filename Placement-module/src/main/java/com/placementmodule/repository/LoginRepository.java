package com.placementmodule.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.placementmodule.entities.Login;

@Repository
public interface LoginRepository extends JpaRepository<Login, Integer>{
	
	Login findByUserNameAndPassword(String userName, String password);

}
