package com.senasoft.sena.controllers;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
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

import com.senasoft.sena.exceptions.ResourceNotFoundException;
import com.senasoft.sena.models.Question;
import com.senasoft.sena.services.IQuestionService;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/api/v1/")
public class QuestionController {
    @Autowired
    private IQuestionService questionService;
    
    // Return a object json with the data from certificate
    @GetMapping("/question")
   public List<Question> getAllquestions() {
    return questionService.findAll();
   }

   @PostMapping("/question")
   public Question savequestion(@RequestBody Question question) {
    return questionService.save(question);
   }

   @GetMapping("/question/{id}")
   public ResponseEntity<Question> getquestionById(@PathVariable long id) {
    Question certificate = questionService.findById(id).orElseThrow(()->new ResourceNotFoundException("The question with " + id +" not exist"));
    return ResponseEntity.ok(certificate);
   }
   
   @PutMapping("/question/{id}")
   public ResponseEntity<Question> updateEmployees(@PathVariable Long id,@RequestBody Question updateQuestion){
    Question question = questionService.findById(id)
               .orElseThrow(()->new ResourceNotFoundException("The question not exists in the id " + id));

       question.setOpeningdate(updateQuestion.getOpeningdate());
       question.setClosingdate(updateQuestion.getClosingdate());
       question.setState(updateQuestion.getState());

       Question questionUpdate = questionService.save(question);

       return ResponseEntity.ok(question);
   }
  

   @DeleteMapping("/question/{id}")
   public ResponseEntity<Map<String, Boolean>> deletequestion(@PathVariable long id) {
    Question question = questionService.findById(id)
    .orElseThrow(() -> new ResourceNotFoundException("The question not exists in the id " + id));
    questionService.delete(question);

    Map<String, Boolean> response = new HashMap<>();
        response.put("delete", Boolean.TRUE);
        return ResponseEntity.ok(response);
    }
}
