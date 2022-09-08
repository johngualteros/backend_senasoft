package com.senasoft.sena.services;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.senasoft.sena.models.Certification;

// implementation of JpaRepository in charge of handling the information found in the database
@Repository
public interface ICertificationService extends JpaRepository<Certification, Long> {

}
