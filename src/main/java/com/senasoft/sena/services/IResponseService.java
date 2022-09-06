package com.senasoft.sena.services;

import org.springframework.data.jpa.repository.JpaRepository;

import com.senasoft.sena.models.Response;

public interface IResponseService extends JpaRepository<Response, Long> {
    
}
