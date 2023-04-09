package com.ytw.YTWebDesi.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ytw.YTWebDesi.model.CourseDetail;
import com.ytw.YTWebDesi.repository.CourseDetailRepository;

@Service
public class CourseDetailService {
	
	@Autowired
	CourseDetailRepository courseDetailRepository;
	public CourseDetail getCourse(int courseId) {
		Optional<CourseDetail> course = courseDetailRepository.findById(courseId);
		if (course.isPresent()) {
			CourseDetail _course=course.get();
			return(_course);
		} else {
			return(null);
		}
	}
}
