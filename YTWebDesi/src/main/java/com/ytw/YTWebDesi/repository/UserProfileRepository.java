package com.ytw.YTWebDesi.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ytw.YTWebDesi.model.UserProfile;

public interface UserProfileRepository extends JpaRepository<UserProfile, String>{
	
}
