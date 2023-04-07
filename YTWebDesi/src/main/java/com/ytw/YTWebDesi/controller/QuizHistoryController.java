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

import com.ytw.YTWebDesi.model.QuizHistory;
import com.ytw.YTWebDesi.repository.QuizHistoryRepository;

@RestController
@RequestMapping("/muniCodingZone")
public class QuizHistoryController {
	
	@Autowired
	QuizHistoryRepository quizHistoryRepository;
	
	// List User Test History
	@GetMapping("/listTestHistory")
	public ResponseEntity<List<QuizHistory>> getTestHistory() {
		try {
			List<QuizHistory> quizHistory= quizHistoryRepository.findAll();
			return new ResponseEntity<>(quizHistory, HttpStatus.OK);
		}catch(Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	// Add Test History
	@PostMapping("/addNew/testHistory")
	public ResponseEntity<QuizHistory> createTestHistory(@RequestBody QuizHistory history) {
		try {
			history.setCreatedDateTime(new Date());
			history.setLastUpdatedDateTime(new Date());
			QuizHistory _history=quizHistoryRepository.save(history);
			return new ResponseEntity<>(_history, HttpStatus.CREATED);
		}catch (Exception e) {
		      return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	// Update Specific Test History Using quizHistoryId
	@PutMapping("/update/testHistory/{quizHistoryId}")
	public ResponseEntity<QuizHistory> updateTestHistory(@PathVariable("quizHistoryId") int quizHistoryId, @RequestBody QuizHistory history) {
		Optional<QuizHistory> historyDb=quizHistoryRepository.findById(quizHistoryId);
		try {
			if(historyDb.isPresent()) {
				QuizHistory _history=historyDb.get();
			
				_history.setUserId(history.getUserId());
				_history.setTotalQuestion(history.getTotalQuestion());
				_history.setCorrect(history.getCorrect());
				_history.setWrong(history.getWrong());
				_history.setNotAnswered(history.getNotAnswered());
				
				_history.setLastUpdatedDateTime(new Date());
				
				// Saving Updated Test History Details To DataBase
				QuizHistory _historyDb=quizHistoryRepository.save(_history);
				return new ResponseEntity<>(_historyDb, HttpStatus.OK);
			}else {
				return new ResponseEntity<>(HttpStatus.NOT_FOUND);
			}
		}catch (Exception e) {
		      return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	// Deleting A Specific Test History
	@DeleteMapping("/delete/testHistory/{quizHistoryId}")
	public ResponseEntity<HttpStatus> deleteTestHistory(@PathVariable("quizHistoryId") int quizHistoryId) {
		try {
			quizHistoryRepository.deleteById(quizHistoryId);
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	    } catch (Exception e) {
	    	return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
	    }
	}
	
	// Find Specific Test History
	@GetMapping("/search/testHistory/{quizHistoryId}")
	public ResponseEntity<QuizHistory> getTestHistoryByQuizHistoryId(@PathVariable("quizHistoryId") int quizHistoryId) {
		try {
			Optional<QuizHistory> history = quizHistoryRepository.findById(quizHistoryId);
			if (history.isPresent()) {
				QuizHistory _history=history.get();
				return new ResponseEntity<>(_history, HttpStatus.FOUND);
			} else {
				return new ResponseEntity<>(HttpStatus.NOT_FOUND);
			}
		}catch (Exception e) {
	    	return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
	    }
	}
	
}


// Created By : Muni Singh




