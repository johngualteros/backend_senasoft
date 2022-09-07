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
import com.senasoft.sena.models.Cuestion;
import com.senasoft.sena.services.ICuestionService;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/api/v1/")
public class QuestionController {
    @Autowired
    private ICuestionService cuestionService;
    
    // Return a object json with the data from certificate
    @GetMapping("/question")
   public List<Cuestion> getAllCuestions() {
    return cuestionService.findAll();
   }

   @PostMapping("/question")
   public Cuestion saveCuestion(@RequestBody Cuestion Cuestion) {
    return cuestionService.save(Cuestion);
   }

   @GetMapping("/question/{id}")
   public ResponseEntity<Cuestion> getCuestionById(@PathVariable long id) {
    Cuestion certificate = cuestionService.findById(id).orElseThrow(()->new ResourceNotFoundException("The Cuestion with " + id +" not exist"));
    return ResponseEntity.ok(certificate);
   }
   
   @PutMapping("/question/{id}")
   public ResponseEntity<Cuestion> updateEmployees(@PathVariable Long id,@RequestBody Cuestion updateCuestion){
       Cuestion cuestion = cuestionService.findById(id)
               .orElseThrow(()->new ResourceNotFoundException("The Cuestion not exists in the id " + id));

       cuestion.setOpeningdate(updateCuestion.getOpeningdate());
       cuestion.setClosingdate(updateCuestion.getClosingdate());
       cuestion.setState(updateCuestion.getState());

       Cuestion cuestionUpdate = cuestionService.save(cuestion);

       return ResponseEntity.ok(cuestion);
   }
  

   @DeleteMapping("/question/{id}")
   public ResponseEntity<Map<String, Boolean>> deleteCuestion(@PathVariable long id) {
    Cuestion cuestion = cuestionService.findById(id)
    .orElseThrow(() -> new ResourceNotFoundException("The Cuestion not exists in the id " + id));
    cuestionService.delete(cuestion);

    Map<String, Boolean> response = new HashMap<>();
        response.put("delete", Boolean.TRUE);
        return ResponseEntity.ok(response);
    }
}
