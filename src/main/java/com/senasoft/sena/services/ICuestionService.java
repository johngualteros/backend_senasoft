package com.senasoft.sena.services;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.senasoft.sena.models.Cuestion;

@Repository
public interface ICuestionService extends JpaRepository<Cuestion, Long> {
    
}
