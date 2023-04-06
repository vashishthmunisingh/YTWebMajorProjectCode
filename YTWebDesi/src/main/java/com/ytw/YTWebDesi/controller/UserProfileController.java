package com.ytw.YTWebDesi.controller;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ytw.YTWebDesi.model.UserProfile;
import com.ytw.YTWebDesi.repository.UserProfileRepository;

@RestController
@RequestMapping("/muniCodingZone")
public class UserProfileController {
	
	@Autowired
	UserProfileRepository userProfileRepository;
	
	// List All The User Profile Available
	@GetMapping("/listAllUserProfile")
	public ResponseEntity<List<UserProfile>> getAllUserProfile() {
		try {
			List<UserProfile> usersProfile= userProfileRepository.findAll();
			return new ResponseEntity<>(usersProfile, HttpStatus.OK);
		}catch(Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	// Add New User Profile
	@PostMapping("/addNew/userProfile")
	public ResponseEntity<UserProfile> createUserProfile(@RequestBody UserProfile userProfile) {
		try {
			userProfile.setCreatedDateTime(new Date());
			userProfile.setLastUpdatedDateTime(new Date());
			UserProfile _userProfile=userProfileRepository.save(userProfile);
			return new ResponseEntity<>(_userProfile, HttpStatus.CREATED);
		}catch (Exception e) {
		      return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	// Update Specific User Profile Using userId
	@PutMapping("/update/userProfile/{userId}")
	public ResponseEntity<UserProfile> updateUserProfile(@PathVariable("userId") String userId, @RequestBody UserProfile userProfile) {
		Optional<UserProfile> userProfileDb=userProfileRepository.findById(userId);
		try {
			if(userProfileDb.isPresent()) {
				UserProfile _userProfileDb=userProfileDb.get();
				
				_userProfileDb.setCountry(userProfile.getCountry());
				_userProfileDb.setState(userProfile.getState());
				_userProfileDb.setCity(userProfile.getCity());
				_userProfileDb.setPincode(userProfile.getPincode());
				_userProfileDb.setCompleteAddress(userProfile.getCompleteAddress());
				_userProfileDb.setImage(userProfile.getImage());
				_userProfileDb.setLastUpdatedDateTime(new Date());
				
				// Saving Updated User Profile To DB
				UserProfile _userProfile=userProfileRepository.save(_userProfileDb);
				return new ResponseEntity<>(_userProfile, HttpStatus.OK);
			}else {
				return new ResponseEntity<>(HttpStatus.NOT_FOUND);
			}
		}catch (Exception e) {
		      return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	// Deleting A Specific User Profile
	@DeleteMapping("/delete/userProfile/{userId}")
	public ResponseEntity<HttpStatus> deleteUserProfileByUserId(@PathVariable("userId") String userId) {
		try {
			userProfileRepository.deleteById(userId);
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	    } catch (Exception e) {
	    	return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
	    }
	}
	
	// Find Specific User Profile
	@GetMapping("/search/userProfile/{userId}")
	public ResponseEntity<UserProfile> getUserProfileByUserId(@PathVariable("userId") String userId) {
		try {
			Optional<UserProfile> userProfile = userProfileRepository.findById(userId);
			if (userProfile.isPresent()) {
				UserProfile _userProfile=userProfile.get();
				return new ResponseEntity<>(_userProfile, HttpStatus.OK);
			} else {
				return new ResponseEntity<>(HttpStatus.NOT_FOUND);
			}
		}catch (Exception e) {
	    	return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
	    }
	}
	
}








