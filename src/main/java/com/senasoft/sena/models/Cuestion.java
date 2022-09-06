package com.senasoft.sena.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table()
public class Cuestion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    
}
