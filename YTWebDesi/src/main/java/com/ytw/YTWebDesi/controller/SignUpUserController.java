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

import com.ytw.YTWebDesi.model.SignUpUser;
import com.ytw.YTWebDesi.repository.SignUpUserRepository;

@RestController
@RequestMapping("/muniCodingZone")
public class SignUpUserController {
	
	@Autowired
	SignUpUserRepository signUpUserRepository;
	
	// SignUpUser
	// List All The SignedUp User Available
	@GetMapping("/listAllSignedUpUser")
	public ResponseEntity<List<SignUpUser>> getAllSignedUpUser() {
		try {
			List<SignUpUser> signUpUser= signUpUserRepository.findAll();
			return new ResponseEntity<>(signUpUser, HttpStatus.OK);
		}catch(Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	// Add SignUp User
	@PostMapping("/addNew/signUpUser")
	public ResponseEntity<SignUpUser> createSignUpUser(@RequestBody SignUpUser signUpUser) {
		try {
			signUpUser.setCreatedDateTime(new Date());
			signUpUser.setLastUpdatedDateTime(new Date());
			SignUpUser _signUpUser=signUpUserRepository.save(signUpUser);
			return new ResponseEntity<>(_signUpUser, HttpStatus.CREATED);
		}catch (Exception e) {
		      return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	// Update Specific User Profile Using userId : Only Role Updating, 
	// Password upadting will be handeled by Other Controller, 
	// userName will never be changed once registered
	@PutMapping("/update/signedUpUser/{userName}")
	public ResponseEntity<SignUpUser> updateSignedUpUserRole(@PathVariable("userName") String userName, @RequestBody SignUpUser signUpUser) {
		Optional<SignUpUser> signUpUserDb=signUpUserRepository.findById(userName);
		try {
			if(signUpUserDb.isPresent()) {
				SignUpUser _signUpUserDb=signUpUserDb.get();
				_signUpUserDb.setRole(signUpUser.getRole());
				_signUpUserDb.setLastUpdatedDateTime(new Date());
				
				// Saving Updated SignUp User Details To DB
				SignUpUser _signUpUser=signUpUserRepository.save(_signUpUserDb);
				return new ResponseEntity<>(_signUpUser, HttpStatus.OK);
			}else {
				return new ResponseEntity<>(HttpStatus.NOT_FOUND);
			}
		}catch (Exception e) {
		      return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	// Deleting A Specific SignedUp User Detail
	@DeleteMapping("/delete/signedUpUser/{userName}")
	public ResponseEntity<HttpStatus> deleteSignedUpUserByUserName(@PathVariable("userName") String userName) {
		try {
			signUpUserRepository.deleteById(userName);
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	    } catch (Exception e) {
	    	return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
	    }
	}
	
	// Find Specific SignedUp User Detail
	@GetMapping("/search/signedUpUser/{userName}")
	public ResponseEntity<SignUpUser> getSignedUpUserByUserName(@PathVariable("userName") String userName) {
		try {
			Optional<SignUpUser> signUpUser = signUpUserRepository.findById(userName);
			if (signUpUser.isPresent()) {
				SignUpUser _signUpUser=signUpUser.get();
				return new ResponseEntity<>(_signUpUser, HttpStatus.FOUND);
			} else {
				return new ResponseEntity<>(HttpStatus.NOT_FOUND);
			}
		}catch (Exception e) {
	    	return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
	    }
	}
	
}





