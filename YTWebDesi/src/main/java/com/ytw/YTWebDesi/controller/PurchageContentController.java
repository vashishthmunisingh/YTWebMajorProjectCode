package com.ytw.YTWebDesi.controller;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ytw.YTWebDesi.model.UserPurchagedCourseDetails;
import com.ytw.YTWebDesi.model.UserPurchagedVideoDetails;
import com.ytw.YTWebDesi.repository.UserPurchagedCourseDetailsRepository;
import com.ytw.YTWebDesi.repository.UserPurchagedVideoDetailsRepository;

@RestController
@RequestMapping("/muniCodingZone/purchage")
public class PurchageContentController {
	
	@Autowired
	UserPurchagedCourseDetailsRepository userPurchagedCourseDetailsRepository;
	
	@Autowired
	UserPurchagedVideoDetailsRepository userPurchagedVideoDetailsRepository;
	
	
	// List All The Purchaged Course : For ADMIN
	@GetMapping("/purchaged/courses")
	public ResponseEntity<List<UserPurchagedCourseDetails>> listAllPurchagedCourse() {
		try {
			List<UserPurchagedCourseDetails>  purchagedCourseList=userPurchagedCourseDetailsRepository.findAll();
			return new ResponseEntity<>(purchagedCourseList, HttpStatus.OK);
		}catch(Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	// List All The Purchaged Course By UserId : For USER
	@GetMapping("/purchaged/courses/{userId}")
	public ResponseEntity<List<UserPurchagedCourseDetails>> listAllPurchagedCourseByUserId(@PathVariable("userId") String userId) {
		try {
			List<UserPurchagedCourseDetails>  purchagedCourseList=userPurchagedCourseDetailsRepository.findByUserId(userId);
			return new ResponseEntity<>(purchagedCourseList, HttpStatus.OK);
		}catch(Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	
	// List All The Purchaged Video : For ADMIN
	@GetMapping("/purchaged/video")
	public ResponseEntity<List<UserPurchagedVideoDetails>> listAllPurchagedVideo() {
		try {
			List<UserPurchagedVideoDetails>  purchagedVideoList=userPurchagedVideoDetailsRepository.findAll();
			return new ResponseEntity<>(purchagedVideoList, HttpStatus.OK);
		}catch(Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	// List All The Purchaged Video By UserId: For USER
	@GetMapping("/purchaged/video/{userId}")
	public ResponseEntity<List<UserPurchagedVideoDetails>> listAllPurchagedVideoByUserId(@PathVariable("userId") String userId) {
		try {
			List<UserPurchagedVideoDetails>  purchagedVideoList=userPurchagedVideoDetailsRepository.findByUserId(userId);
			return new ResponseEntity<>(purchagedVideoList, HttpStatus.OK);
		}catch(Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	// For Purchaging New Course/Video
	@PostMapping("/purchageCourseOrVideo/{isCourseOrVideo}/{userId}/{courseOrVideoId}")
	public ResponseEntity<HttpStatus> purchageCourseOrVideo(@PathVariable("isCourseOrVideo") String isCourseOrVideo,@PathVariable("userId") String userId,@PathVariable("courseOrVideoId") int courseOrVideoId) {
		try {
			if(isCourseOrVideo.equalsIgnoreCase("isCourse")) {
				UserPurchagedCourseDetails userPurchagedCourseDetails=new UserPurchagedCourseDetails();
				userPurchagedCourseDetails.setUserId(userId);
				userPurchagedCourseDetails.setCourseId(courseOrVideoId);
				userPurchagedCourseDetails.setCoursePurchagedDateTime(new Date());
			
				userPurchagedCourseDetailsRepository.save(userPurchagedCourseDetails);
			
				return new ResponseEntity<>(HttpStatus.CREATED);
			
			}else if(isCourseOrVideo.equalsIgnoreCase("isVideo")) {
				UserPurchagedVideoDetails userPurchagedVideoDetails=new UserPurchagedVideoDetails();
				userPurchagedVideoDetails.setUserId(userId);
				userPurchagedVideoDetails.setVideoId(courseOrVideoId);
				userPurchagedVideoDetails.setVideoPurchagedDateTime(new Date());
			
				userPurchagedVideoDetailsRepository.save(userPurchagedVideoDetails);
				return new ResponseEntity<>(HttpStatus.CREATED);
			}else
				return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}catch (Exception e) {
		      return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	// Remove Specific User Purchaged Course/Video : For ADMIN
	@DeleteMapping("/remove/userSpeCorV/{isCourseOrVideo}/{purchagedCorVId}")
	public ResponseEntity<HttpStatus> removeUserPurchagedCourseOrVideoFromHisList(@PathVariable("isCourseOrVideo") String isCourseOrVideo,@PathVariable("purchagedCorVId") int purchagedCorVId) {
		try {
			if(isCourseOrVideo.equalsIgnoreCase("isCourse")) {
				userPurchagedCourseDetailsRepository.deleteById(purchagedCorVId);
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}else if(isCourseOrVideo.equalsIgnoreCase("isVideo")) {
				userPurchagedVideoDetailsRepository.deleteById(purchagedCorVId);
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}else 
				return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
			
	    } catch (Exception e) {
	    	return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
	    }
	}
	
	
}












