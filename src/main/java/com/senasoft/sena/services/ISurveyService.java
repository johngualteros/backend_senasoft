package com.senasoft.sena.services;

import org.springframework.data.jpa.repository.JpaRepository;

import com.senasoft.sena.models.Survey;

public interface ISurveyService extends JpaRepository<Survey, Long> {
    
}
