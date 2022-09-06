package com.senasoft.sena.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table
public class Survey {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idsurvey;

    @Column(name = "theme", length = 20)
    private String theme;

    public Long getIdsurvey() {
        return idsurvey;
    }

    public void setIdsurvey(Long idsurvey) {
        this.idsurvey = idsurvey;
    }

    public String getTheme() {
        return theme;
    }

    public void setTheme(String theme) {
        this.theme = theme;
    }

    public Survey() {
    }

    public Survey(Long idsurvey, String theme) {
        this.idsurvey = idsurvey;
        this.theme = theme;
    }

    public Survey(String theme) {
        this.theme = theme;
    }

}
