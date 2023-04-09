package com.ytw.YTWebDesi.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ytw.YTWebDesi.model.UserPurchagedCourseDetails;

public interface UserPurchagedCourseDetailsRepository extends JpaRepository<UserPurchagedCourseDetails, Integer>{
	List<UserPurchagedCourseDetails> findByUserId(String userId);
}