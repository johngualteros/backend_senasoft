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

import com.senasoft.sena.services.IUserService;
import com.senasoft.sena.exceptions.ResourceNotFoundException;
import com.senasoft.sena.models.*;

import java.io.Console;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.web.bind.annotation.RequestParam;


@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/api/v1/")
public class UserController {
    
    @Autowired
    private IUserService userService;

    //return the list of users in the database
    @GetMapping("/users")
    public List<User> getAllUsers(){
        return userService.findAll();
    }

    @GetMapping("/user/{email}/{password}")
    public Boolean validateUser(@PathVariable String email, @PathVariable String password){
        System.out.println("validateUser: " + email + " " + password);
        User resultado = userService.search(email, password);
        if (resultado != null) {
            System.out.println("resultado: " + resultado.getEmail() + "" +resultado.getName());
            return true;
        }
        return false;
    }

    //return the user created in the database
    @PostMapping("/users")
    public User createUser(@RequestBody User user){
        return userService.save(user);
    }

    //return the unique user if this is found in the database
    @GetMapping("/users/{id}")
    public ResponseEntity<User> getUserById(@PathVariable long id) {
     User user = userService.findById(id).orElseThrow(()->new ResourceNotFoundException("The certification with " + id +" not exist"));
        return ResponseEntity.ok(user);
    }

    // return a response entity for the specified user if it is found in the database and updated
    @PutMapping("/users/{id}")
    public ResponseEntity<User> updateUser(@PathVariable Long id,@RequestBody User userUpdated){
        User user = userService.findById(id)
                .orElseThrow(()->new ResourceNotFoundException("The user not exists in the id " + id));

        user.setNumberdocument(userUpdated.getNumberdocument());
        user.setName(userUpdated.getName());
        user.setLastname(userUpdated.getLastname());
        user.setAddress(userUpdated.getAddress());
        user.setEmail(userUpdated.getEmail());
        user.setNumberphone(userUpdated.getNumberphone());
        user.setLandline(userUpdated.getLandline());
        user.setDatebirth(userUpdated.getDatebirth());
        user.setMunicipality(userUpdated.getMunicipality());
        user.setStratum(userUpdated.getStratum());
        user.setAcademiclevel(userUpdated.getAcademiclevel());
        user.setSex(userUpdated.getSex());
        user.setAffiliationregime(userUpdated.getAffiliationregime());
        user.setDisabilitycondition(userUpdated.getDisabilitycondition());
        user.setEthnicity(userUpdated.getEthnicity());
        user.setTechnologicalaccess(userUpdated.getTechnologicalaccess());
        user.setRole(userUpdated.getRole());
        user.setPassword(userUpdated.getPassword());
        user.setSurvey(userUpdated.getSurvey());

        User userUpdate = userService.save(user);

        return ResponseEntity.ok(user);
    }
    
    // return a response entity for the specified user if it is found in the database and deleted
    @DeleteMapping("/users/{id}")
    public ResponseEntity<Map<String,Boolean>> deleteUser(@PathVariable Long id) {
        User user = userService.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("The user not exists in the id " + id));

        userService.delete(user);
        Map<String, Boolean> response = new HashMap<>();
        response.put("delete", Boolean.TRUE);
        return ResponseEntity.ok(response);
    }
}
