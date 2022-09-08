package com.senasoft.sena.services;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.senasoft.sena.models.User;


@Repository
public interface IUserService extends JpaRepository<User, Long>{
    
    @Query( value = "SELECT * FROM user u WHERE u.email = ?1 AND u.password = ?2", 
    nativeQuery = true)
    public User search(String email, String password);

    @Query(value="SELECT * FROM user u WHERE u.email = ?1", nativeQuery=true)
    public User findByEmail(String email);

}
