package com.senasoft.sena.services;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.senasoft.sena.models.Question;

@Repository
public interface IQuestionService extends JpaRepository<Question, Long> {
    
}
