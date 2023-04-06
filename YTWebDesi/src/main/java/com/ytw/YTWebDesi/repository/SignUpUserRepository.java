package com.ytw.YTWebDesi.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ytw.YTWebDesi.model.SignUpUser;

public interface SignUpUserRepository extends JpaRepository<SignUpUser, String>{
	
}
