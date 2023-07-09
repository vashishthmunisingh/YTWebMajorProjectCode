package com.ytw.YTWebDesi.controller;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ytw.YTWebDesi.model.CoursesVideosList;
import com.ytw.YTWebDesi.repository.CoursesVideosListRepository;

@RestController
@RequestMapping("/muniCodingZone")
@CrossOrigin(origins = "http://localhost:3000/")
public class CoursesVideosListController {
	
	@Autowired
	CoursesVideosListRepository coursesVideosListRepository;
	
	// List All The Courses Available
	@GetMapping("/listSpecificCourseVideos/{courseId}")
	public ResponseEntity<List<CoursesVideosList>> getSpecificCourseVideosList(@PathVariable("courseId") int courseId) {
		try {
			List<CoursesVideosList> specificCourseVideosList= coursesVideosListRepository.findBycourseId(courseId);
			return new ResponseEntity<>(specificCourseVideosList, HttpStatus.OK);
		}catch(Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	// Add A Specific Course Video
	@PostMapping("/course/newVideo")
	public ResponseEntity<CoursesVideosList> createCourse(@RequestBody CoursesVideosList coursesVideos) {
		try {
			coursesVideos.setCreatedDateTime(new Date());
			coursesVideos.setLastUpdatedDateTime(new Date());
			CoursesVideosList _coursesVideos=coursesVideosListRepository.save(coursesVideos);
			return new ResponseEntity<>(_coursesVideos, HttpStatus.CREATED);
		}catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	// Update Specific Course Video Using VideoId
	@PutMapping("/update/specificVideo/{videoId}")
	public ResponseEntity<CoursesVideosList> updateSpecificCourseVideo(@PathVariable("videoId") int videoId,@RequestBody CoursesVideosList coursesVideo) {
		Optional<CoursesVideosList> coursesVideoDb=coursesVideosListRepository.findById(videoId);
		try {
			if(coursesVideoDb.isPresent()) {
				CoursesVideosList _coursesVideoDb=coursesVideoDb.get();
				_coursesVideoDb.setCourseId(coursesVideo.getCourseId());
				_coursesVideoDb.setYtVideoId(coursesVideo.getYtVideoId());
				_coursesVideoDb.setVideoTitle(coursesVideo.getVideoTitle());
				_coursesVideoDb.setIsPaid(coursesVideo.getIsPaid());
				_coursesVideoDb.setVideoFee(coursesVideo.getVideoFee());
				_coursesVideoDb.setLastUpdatedDateTime(new Date());
				
				// Saving Updated Video Details To Database
				CoursesVideosList _video=coursesVideosListRepository.save(_coursesVideoDb);
				return new ResponseEntity<>(_video,HttpStatus.OK);
			}else {
				return new ResponseEntity<>(HttpStatus.NOT_FOUND);
			}
		}catch (Exception e) {
		      return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	// Delete Specific Course Video Using VideoId
	@DeleteMapping("delete/video/{videoId}")
	public ResponseEntity<HttpStatus> deleteSpecificCourseVideo(@PathVariable("videoId") int videoId) {
		try {
			coursesVideosListRepository.deleteById(videoId);
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	    } catch (Exception e) {
	    	return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
	    }
	}
	
	// Find Specific Course
	@GetMapping("/search/video/{videoId}")
	public ResponseEntity<CoursesVideosList> getVideoByVideoId(@PathVariable("videoId") int videoId) {
		try {
			Optional<CoursesVideosList> video = coursesVideosListRepository.findById(videoId);
			if (video.isPresent()) {
				CoursesVideosList _video=video.get();
				return new ResponseEntity<>(_video, HttpStatus.FOUND);
			} else {
				return new ResponseEntity<>(HttpStatus.NOT_FOUND);
			}
		}catch (Exception e) {
		    return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
}













