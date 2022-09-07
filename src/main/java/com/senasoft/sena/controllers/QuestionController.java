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
    private IQuestionService cuestionService;
    
    // Return a object json with the data from certificate
    @GetMapping("/Cuestion")
   public List<Question> getAllCuestions() {
    return cuestionService.findAll();
   }

   @PostMapping("/cuestion")
   public Question saveCuestion(@RequestBody Question Cuestion) {
    return cuestionService.save(Cuestion);
   }

   @GetMapping("/Cuestion/{id}")
   public ResponseEntity<Question> getCuestionById(@PathVariable long id) {
    Question certificate = cuestionService.findById(id).orElseThrow(()->new ResourceNotFoundException("The Cuestion with " + id +" not exist"));
    return ResponseEntity.ok(certificate);
   }
   
   @PutMapping("/cuestion/{id}")
   public ResponseEntity<Question> updateEmployees(@PathVariable Long id,@RequestBody Question updateCuestion){
       Question cuestion = cuestionService.findById(id)
               .orElseThrow(()->new ResourceNotFoundException("The Cuestion not exists in the id " + id));

       cuestion.setOpeningdate(updateCuestion.getOpeningdate());
       cuestion.setClosingdate(updateCuestion.getClosingdate());
       cuestion.setState(updateCuestion.getState());

       Question cuestionUpdate = cuestionService.save(cuestion);

       return ResponseEntity.ok(cuestion);
   }
  

   @DeleteMapping("/Cuestion/{id}")
   public ResponseEntity<Map<String, Boolean>> deleteCuestion(@PathVariable long id) {
    Question cuestion = cuestionService.findById(id)
    .orElseThrow(() -> new ResourceNotFoundException("The Cuestion not exists in the id " + id));
    cuestionService.delete(cuestion);

    Map<String, Boolean> response = new HashMap<>();
        response.put("delete", Boolean.TRUE);
        return ResponseEntity.ok(response);
    }
}
