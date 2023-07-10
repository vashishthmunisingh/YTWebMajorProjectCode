package com.ytw.YTWebDesi.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ytw.YTWebDesi.model.Comments;

public interface CommentsRepository extends JpaRepository<Comments, Integer>{
	List<Comments> findByCommentsMadeOnCourseCourseId(int commentsMadeOnCourseCourseId);
	List<Comments> findByCommentsMadeOnVideoVideoId(int commentsMadeOnVideoVideoId);
}
