package com.ytw.YTWebDesi.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ytw.YTWebDesi.model.CoursesVideosList;

public interface CoursesVideosListRepository extends JpaRepository<CoursesVideosList, Integer>{
	List<CoursesVideosList> findBycourseId(int courseId);
}