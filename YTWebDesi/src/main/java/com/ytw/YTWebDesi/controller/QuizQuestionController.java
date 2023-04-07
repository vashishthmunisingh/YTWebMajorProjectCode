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

import com.ytw.YTWebDesi.model.QuizQuestion;
import com.ytw.YTWebDesi.repository.QuizQuestionRepository;

@RestController
@RequestMapping("/muniCodingZone")
public class QuizQuestionController {

	@Autowired
	QuizQuestionRepository quizQuestionRepository;
	
	// List All The Test Question Available
	@GetMapping("/listTestQuestion")
	public ResponseEntity<List<QuizQuestion>> getTestQuestion() {
		try {
			List<QuizQuestion> quizQuestion= quizQuestionRepository.findAll();
			return new ResponseEntity<>(quizQuestion, HttpStatus.OK);
		}catch(Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	// Add Test Question
	@PostMapping("/addNew/testQuestion")
	public ResponseEntity<QuizQuestion> createTestQuestion(@RequestBody QuizQuestion question) {
		try {
			question.setCreatedDateTime(new Date());
			question.setLastUpdatedDateTime(new Date());
			QuizQuestion _question=quizQuestionRepository.save(question);
			return new ResponseEntity<>(_question, HttpStatus.CREATED);
		}catch (Exception e) {
		      return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	// Update Specific Question Details Using questionId
	@PutMapping("/update/question/{questionId}")
	public ResponseEntity<QuizQuestion> updateQuestion(@PathVariable("questionId") int questionId, @RequestBody QuizQuestion question) {
		Optional<QuizQuestion> questionDb=quizQuestionRepository.findById(questionId);
		try {
			if(questionDb.isPresent()) {
				QuizQuestion _question=questionDb.get();
			
				_question.setCourseId(question.getCourseId());
				
				_question.setQuestion(question.getQuestion());
				
				_question.setOptionA(question.getOptionA());
				_question.setOptionB(question.getOptionB());
				_question.setOptionC(question.getOptionC());
				_question.setOptionD(question.getOptionD());
				
				_question.setCorrectOption(question.getCorrectOption());
				
				_question.setQuestionimg(question.getQuestionimg());
				
				_question.setLastUpdatedDateTime(new Date());
				
				// Saving Updated Question Details To DataBase
				QuizQuestion _questionDb=quizQuestionRepository.save(_question);
				return new ResponseEntity<>(_questionDb, HttpStatus.OK);
			}else {
				return new ResponseEntity<>(HttpStatus.NOT_FOUND);
			}
		}catch (Exception e) {
		      return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	// Deleting A Specific Question
	@DeleteMapping("/delete/question/{questionId}")
	public ResponseEntity<HttpStatus> deleteQuestion(@PathVariable("questionId") int questionId) {
		try {
			quizQuestionRepository.deleteById(questionId);
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	    } catch (Exception e) {
	    	return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
	    }
	}
	
	// Find Specific Question
	@GetMapping("/search/question/{questionId}")
	public ResponseEntity<QuizQuestion> getQuestionByQuestionId(@PathVariable("questionId") int questionId) {
		try {
			Optional<QuizQuestion> question = quizQuestionRepository.findById(questionId);
			if (question.isPresent()) {
				QuizQuestion _question=question.get();
				return new ResponseEntity<>(_question, HttpStatus.FOUND);
			} else {
				return new ResponseEntity<>(HttpStatus.NOT_FOUND);
			}
		}catch (Exception e) {
	    	return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
	    }
	}
	
}


// Muni Singh



