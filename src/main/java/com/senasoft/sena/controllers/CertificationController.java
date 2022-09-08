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

import com.senasoft.sena.exceptions.ResourceNotFoundException;
import com.senasoft.sena.models.Certification;
import com.senasoft.sena.services.ICertificationService;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/api/v1/")
public class CertificationController {
    
    @Autowired
    private ICertificationService certificationService;
    
    // Return a object json with the data from certificate
    @GetMapping("/certification")
   public List<Certification> getAllCertifications() {
    return certificationService.findAll();
   }

   //save the certificate in the database
   @PostMapping("certificaction")
   public Certification saveCertification(@RequestBody Certification certification) {
    return certificationService.save(certification);
   }

   // returns a certificate that has been saved in the database
   @GetMapping("/certification/{id}")
   public ResponseEntity<Certification> getCertificationById(@PathVariable long id) {
    Certification certificate = certificationService.findById(id).orElseThrow(()->new ResourceNotFoundException("The certification with " + id +" not exist"));
    return ResponseEntity.ok(certificate);
   }

  

   @DeleteMapping("/certification/{id}")
   public ResponseEntity<Map<String, Boolean>> deleteCertification(@PathVariable long id) {
    Certification certificate = certificationService.findById(id)
    .orElseThrow(() -> new ResourceNotFoundException("The Certification not exists in the id " + id));
    certificationService.delete(certificate);

    Map<String, Boolean> response = new HashMap<>();
        response.put("delete", Boolean.TRUE);
        return ResponseEntity.ok(response);
    }


}
