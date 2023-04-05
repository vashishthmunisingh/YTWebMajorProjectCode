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

import com.ytw.YTWebDesi.model.CourseDetail;
import com.ytw.YTWebDesi.repository.CourseDetailRepository;

@RestController
@RequestMapping("/muniCodingZone")
public class CourseDetailsController {
	
	@Autowired
	CourseDetailRepository courseDetailRepository;
	
	// List All The Courses Available
	@GetMapping("/list")
	public ResponseEntity<List<CourseDetail>> getCourseList() {
		try {
			List<CourseDetail> courseList= courseDetailRepository.findAll();
			return new ResponseEntity<>(courseList, HttpStatus.OK);
		}catch(Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	// Add A Specific Course
	@PostMapping("/course")
	public ResponseEntity<CourseDetail> createCourse(@RequestBody CourseDetail course) {
		try {
			course.setCourseAuthor("Muni Singh");
			course.setCreatedDateTime(new Date());
			course.setLastUpdatedDateTime(new Date());
			CourseDetail _course=courseDetailRepository.save(course);
			return new ResponseEntity<>(_course, HttpStatus.CREATED);
		}catch (Exception e) {
		      return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	// Update Specific Course Details Using Course Id
	@PutMapping("/update/{courseId}")
	public ResponseEntity<CourseDetail> updateCourse(@PathVariable("courseId") int courseId, @RequestBody CourseDetail course) {
		Optional<CourseDetail> courseDetail=courseDetailRepository.findById(courseId);
		try {
			if(courseDetail.isPresent()) {
				CourseDetail _courseDetail=courseDetail.get();
			
				_courseDetail.setCourseName(course.getCourseName());
				_courseDetail.setCourseDes(course.getCourseDes());
				_courseDetail.setCourseAuthor(course.getCourseAuthor());
				_courseDetail.setLastUpdatedDateTime(new Date());
				_courseDetail.setCourseLogo(course.getCourseLogo());
				_courseDetail.setIsPaid(course.getIsPaid());
				_courseDetail.setCourseFee(course.getCourseFee());
				
				CourseDetail _course=courseDetailRepository.save(_courseDetail);
				return new ResponseEntity<>(_course, HttpStatus.OK);
			}else {
				return new ResponseEntity<>(HttpStatus.NOT_FOUND);
			}
		}catch (Exception e) {
		      return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	// Deleting A Specific Course
	@DeleteMapping("/delete/{courseId}")
	public ResponseEntity<HttpStatus> deleteCourse(@PathVariable("courseId") int courseId) {
		try {
			courseDetailRepository.deleteById(courseId);
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	    } catch (Exception e) {
	    	return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
	    }
	}
	
	
	// Find Specific Course
	@GetMapping("/search/{courseId}")
	public ResponseEntity<CourseDetail> getCourseByCourseId(@PathVariable("courseId") int courseId) {
		try {
			Optional<CourseDetail> course = courseDetailRepository.findById(courseId);
			if (course.isPresent()) {
				CourseDetail _course=course.get();
				return new ResponseEntity<>(_course, HttpStatus.OK);
			} else {
				return new ResponseEntity<>(HttpStatus.NOT_FOUND);
			}
		}catch (Exception e) {
	    	return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
	    }
	}
	
	
}












