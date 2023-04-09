package com.ytw.YTWebDesi.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ytw.YTWebDesi.model.UserPurchagedVideoDetails;

public interface UserPurchagedVideoDetailsRepository extends JpaRepository<UserPurchagedVideoDetails, Integer>{
	List<UserPurchagedVideoDetails> findByUserId(String userId);
}