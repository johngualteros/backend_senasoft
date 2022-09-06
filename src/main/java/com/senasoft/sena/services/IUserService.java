package com.senasoft.sena.services;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.senasoft.sena.models.User;

@Repository
public interface IUserService extends JpaRepository<User, Long>{
    
}
