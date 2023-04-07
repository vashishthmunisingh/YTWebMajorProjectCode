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

import com.ytw.YTWebDesi.model.UserQuery;
import com.ytw.YTWebDesi.repository.UserQueryRepository;

@RestController
@RequestMapping("/muniCodingZone")
public class UserQueryController {
	
	@Autowired
	UserQueryRepository userQueryRepository;
	
	// List All The Users Queries Available
	@GetMapping("/listUserQuery")
	public ResponseEntity<List<UserQuery>> getUserQueryList() {
		try {
			List<UserQuery> userQuery= userQueryRepository.findAll();
			return new ResponseEntity<>(userQuery, HttpStatus.OK);
		}catch(Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	// Add User Query
	@PostMapping("/addNew/userQuery")
	public ResponseEntity<UserQuery> createUserQuery(@RequestBody UserQuery query) {
		try {
			query.setCreatedDateTime(new Date());
			query.setLastUpdatedDateTime(new Date());
			UserQuery _query=userQueryRepository.save(query);
			return new ResponseEntity<>(_query, HttpStatus.CREATED);
		}catch (Exception e) {
		      return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	// Update UserQuery Using queryId
	@PutMapping("/update/query/{queryId}")
	public ResponseEntity<UserQuery> updateQuery(@PathVariable("queryId") int queryId, @RequestBody UserQuery query) {
		Optional<UserQuery> queryDb=userQueryRepository.findById(queryId);
		try {
			if(queryDb.isPresent()) {
				
				UserQuery _queryDb=queryDb.get();
				
				_queryDb.setUserName(query.getUserName());
				_queryDb.setUserEmail(query.getUserEmail());
				_queryDb.setMobileNumber(query.getMobileNumber());
				_queryDb.setCountry(query.getCountry());
				
				_queryDb.setSubject(query.getSubject());
				_queryDb.setUserQueryDetails(query.getUserQueryDetails());
				
				_queryDb.setLastUpdatedDateTime(new Date());
				
				// Saving Updated Query To DB
				UserQuery _query=userQueryRepository.save(_queryDb);
				return new ResponseEntity<>(_query, HttpStatus.OK);
			}else {
				return new ResponseEntity<>(HttpStatus.NOT_FOUND);
			}
		}catch (Exception e) {
		      return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	// Deleting A Specific User Query
	@DeleteMapping("/delete/query/{queryId}")
	public ResponseEntity<HttpStatus> deleteQuery(@PathVariable("queryId") int queryId) {
		try {
			userQueryRepository.deleteById(queryId);
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	    } catch (Exception e) {
	    	return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
	    }
	}
	
	// Find Specific Query
	@GetMapping("/search/query/{queryId}")
	public ResponseEntity<UserQuery> getCourseByCourseId(@PathVariable("queryId") int queryId) {
		try {
			Optional<UserQuery> query = userQueryRepository.findById(queryId);
			if (query.isPresent()) {
				UserQuery _query=query.get();
				return new ResponseEntity<>(_query, HttpStatus.FOUND);
			} else {
				return new ResponseEntity<>(HttpStatus.NOT_FOUND);
			}
		}catch (Exception e) {
	    	return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
	    }
	}
	
	
}




// Creater :  Muni Singh





