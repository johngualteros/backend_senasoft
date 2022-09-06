package com.senasoft.sena.controllers;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.senasoft.sena.exceptions.ResourceNotFoundException;
import com.senasoft.sena.models.Response;
import com.senasoft.sena.services.IResponseService;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/api/v1/")
public class ResponseController {
    @Autowired
    private IResponseService cuestionService;
    
    // Return a object json with the data of the response from to question
    @GetMapping("/response")
   public List<Response> getAllCuestions() {
    return cuestionService.findAll();
   }

   @PostMapping("/response")
   public Response saveCuestion(@RequestBody Response response)  {
    return cuestionService.save(response);
   }

   @GetMapping("/response/{id}")
   public ResponseEntity<Response> getCuestionById(@PathVariable long id) {
    Response certificate = cuestionService.findById(id).orElseThrow(()->new ResourceNotFoundException("The Response with " + id +" not exist"));
    return ResponseEntity.ok(certificate);
   }
   
}
