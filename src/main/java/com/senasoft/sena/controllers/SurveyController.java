package com.senasoft.sena.controllers;

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

import com.senasoft.sena.services.ISurveyService;
import com.senasoft.sena.exceptions.ResourceNotFoundException;
import com.senasoft.sena.models.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.web.bind.annotation.RequestParam;


@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/api/v1/")
public class SurveyController {
    
    @Autowired
    private ISurveyService surveyService;

    //return the list of surveys in the database
    @GetMapping("/survey")
    public List<Survey> getAllsSurveys(){
        List<Survey> listSurvery = surveyService.findAll();
        return listSurvery;
    }

    //return the survey created in the database
    @PostMapping("/survey")
    public Survey createSurvey(@RequestBody Survey survey){
        return surveyService.save(survey);
    }

    //return the unique survey if this is found in the database
    @GetMapping("/survey/{id}")
    public ResponseEntity<Survey> getsurveyById(@PathVariable long id) {
     Survey survey = surveyService.findById(id).orElseThrow(()->new ResourceNotFoundException("The certification with " + id +" not exist"));
        return ResponseEntity.ok(survey);
    }

    // return a response entity for the specified survey if it is found in the database and updated
    @PutMapping("/survey/{id}")
    public ResponseEntity<Survey> updatesurvey(@PathVariable Long id){
        Survey survey = surveyService.findById(id)
                .orElseThrow(()->new ResourceNotFoundException("The survey not exists in the id " + id));

        survey.setStatus(!survey.isStatus());

        Survey surveyUpdate = surveyService.save(survey);

        return ResponseEntity.ok(survey);
    }
    
    // return a response entity for the specified survey if it is found in the database and deleted
    @DeleteMapping("/survey/{id}")
    public ResponseEntity<Map<String,Boolean>> deletesurvey(@PathVariable Long id) {
        Survey survey = surveyService.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("The survey not exists in the id " + id));

        surveyService.delete(survey);
        Map<String, Boolean> response = new HashMap<>();
        response.put("delete", Boolean.TRUE);
        return ResponseEntity.ok(response);
    }
}
