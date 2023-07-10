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

import com.ytw.YTWebDesi.model.CommentsReply;
import com.ytw.YTWebDesi.repository.CommentsReplyRepository;

@RestController
@RequestMapping("/muniCodingZone")
public class CommentsReplyController {

	@Autowired
	CommentsReplyRepository commentsReplyRepository;
	
	// List All Replies
	@GetMapping("/listReplies")
	public ResponseEntity<List<CommentsReply>> getCommentsReplyList() {
		try {
			List<CommentsReply> commentsReplyList= commentsReplyRepository.findAll();
			return new ResponseEntity<>(commentsReplyList, HttpStatus.OK);
		}catch(Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	// List All Replies Made On Particular Comments: commentsId
	@GetMapping("/listReplies/{replyMadeOnCommentsCommentsId}")
	public ResponseEntity<List<CommentsReply>> getCommentsReplyMadeOnCommentsCommentsIdList(@PathVariable("replyMadeOnCommentsCommentsId") int replyMadeOnCommentsCommentsId) {
		try {
			List<CommentsReply> commentsReplyList= commentsReplyRepository.findByReplyMadeOnCommentsCommentsId(replyMadeOnCommentsCommentsId);
			return new ResponseEntity<>(commentsReplyList, HttpStatus.OK);
		}catch(Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	// Make New Reply
	@PostMapping("/addNew/reply")
	public ResponseEntity<CommentsReply> createReply(@RequestBody CommentsReply reply) {
		try {
			reply.setRepliedDateTime(new Date());
			CommentsReply _reply=commentsReplyRepository.save(reply);
			return new ResponseEntity<>(_reply, HttpStatus.CREATED);
		}catch (Exception e) {
		      return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	// Update Reply By ReplyId
	@PutMapping("/update/reply/{replyId}")
	public ResponseEntity<CommentsReply> updateReply(@PathVariable("replyId") int replyId, @RequestBody CommentsReply reply) {
		Optional<CommentsReply> replyDB=commentsReplyRepository.findById(replyId);
		try {
			if(replyDB.isPresent()) {
				CommentsReply _replyDB=replyDB.get();
				
				_replyDB.setCommentsReply(reply.getCommentsReply());
				_replyDB.setRepliedDateTime(new Date());
				
				CommentsReply _reply=commentsReplyRepository.save(_replyDB);
				return new ResponseEntity<>(_reply, HttpStatus.OK);
			}else {
				return new ResponseEntity<>(HttpStatus.NOT_FOUND);
			}
		}catch (Exception e) {
		      return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	// Delete Reply By ReplyId
	@DeleteMapping("/delete/reply/{replyId}")
	public ResponseEntity<HttpStatus> deleteReply(@PathVariable("replyId") int replyId) {
		try {
			commentsReplyRepository.deleteById(replyId);
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	    } catch (Exception e) {
	    	return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
	    }
	}
	
	// Get Reply By ReplyId
	@GetMapping("/search/reply/{replyId}")
	public ResponseEntity<CommentsReply> getReplyByReplyId(@PathVariable("replyId") int replyId) {
		try {
			Optional<CommentsReply> reply = commentsReplyRepository.findById(replyId);
			if (reply.isPresent()) {
				CommentsReply _reply=reply.get();
				return new ResponseEntity<>(_reply, HttpStatus.FOUND);
			} else {
				return new ResponseEntity<>(HttpStatus.NOT_FOUND);
			}
		}catch (Exception e) {
	    	return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
	    }
	}
}






