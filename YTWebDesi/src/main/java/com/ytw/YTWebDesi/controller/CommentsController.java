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

import com.ytw.YTWebDesi.model.Comments;
import com.ytw.YTWebDesi.repository.CommentsRepository;

@RestController
@RequestMapping("/muniCodingZone")
public class CommentsController {
	
	@Autowired
	CommentsRepository commentsRepository;
	
	// List All The Comments
	@GetMapping("/listComments")
	public ResponseEntity<List<Comments>> getCommentsList() {
		try {
			List<Comments> commentList= commentsRepository.findAll();
			return new ResponseEntity<>(commentList, HttpStatus.OK);
		}catch(Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	// List All The Comments By commentsMadeOnCourseCourseId
	@GetMapping("/listCommentsByCourseId/{commentsMadeOnCourseCourseId}")
	public ResponseEntity<List<Comments>> getCommentsListByCommentsMadeOnCourseCourseId(@PathVariable("commentsMadeOnCourseCourseId") int commentsMadeOnCourseCourseId) {
		try {
			List<Comments> commentList= commentsRepository.findByCommentsMadeOnCourseCourseId(commentsMadeOnCourseCourseId);
			return new ResponseEntity<>(commentList, HttpStatus.OK);
		}catch(Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	// List All The Comments By commentsMadeOnVideoVideoId
	@GetMapping("/listCommentsByVideoId/{commentsMadeOnVideoVideoId}")
	public ResponseEntity<List<Comments>> getCommentsListByCommentsMadeOnVideoVideoId(@PathVariable("commentsMadeOnVideoVideoId") int commentsMadeOnVideoVideoId) {
		try {
			List<Comments> commentList= commentsRepository.findByCommentsMadeOnVideoVideoId(commentsMadeOnVideoVideoId);
			return new ResponseEntity<>(commentList, HttpStatus.OK);
		}catch(Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	// Post New Comment
	@PostMapping("/addNew/comment")
	public ResponseEntity<Comments> createComment(@RequestBody Comments comment) {
		try {
			comment.setCommentsMadeDateTime(new Date());
			Comments _comment=commentsRepository.save(comment);
			return new ResponseEntity<>(_comment, HttpStatus.CREATED);
		}catch (Exception e) {
		      return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	// Update Comment By Using CommentsId + Send Updated Comment Message
	@PutMapping("/update/comment/{commentsId}")
	public ResponseEntity<Comments> updateComment(@PathVariable("commentsId") int commentsId, @RequestBody Comments comment) {
		Optional<Comments> commentDB=commentsRepository.findById(commentsId);
		try {
			if(commentDB.isPresent()) {
				Comments _commentDB=commentDB.get();
				
				_commentDB.setComments(comment.getComments());
				_commentDB.setCommentsMadeDateTime(new Date());
				
				Comments _comment=commentsRepository.save(_commentDB);
				return new ResponseEntity<>(_comment, HttpStatus.OK);
			}else {
				return new ResponseEntity<>(HttpStatus.NOT_FOUND);
			}
		}catch (Exception e) {
		      return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	// Delete Comment By Using CommentsId
	@DeleteMapping("/delete/comment/{commentsId}")
	public ResponseEntity<HttpStatus> deleteComment(@PathVariable("commentsId") int commentsId) {
		try {
			commentsRepository.deleteById(commentsId);
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	    } catch (Exception e) {
	    	return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
	    }
	}
	
	// Search Comment By Using CommentsId
	@GetMapping("/search/comment/{commentsId}")
	public ResponseEntity<Comments> getCommentByCommentId(@PathVariable("commentsId") int commentsId) {
		try {
			Optional<Comments> comment = commentsRepository.findById(commentsId);
			if (comment.isPresent()) {
				Comments _comment=comment.get();
				return new ResponseEntity<>(_comment, HttpStatus.FOUND);
			} else {
				return new ResponseEntity<>(HttpStatus.NOT_FOUND);
			}
		}catch (Exception e) {
	    	return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
	    }
	}
	
}










