package com.senasoft.sena.models;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;


@Entity
@Table
public class Survey {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idsurvey;

    @Column(name = "theme", length = 20)
    private String theme;

    @Column(name= "status")
    private boolean status = false;

    @Column(name = "icon", length = 20)
    private String nameIcon;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "surkey_id")
    private List<Question> question;

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

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    

    public Survey() {
    }

    public List<Question> getQuestion() {
        return question;
    }

    public void setQuestion(List<Question> question) {
        this.question = question;
    }

    public Survey(Long idsurvey, String theme, boolean status, List<Question> question) {
        this.idsurvey = idsurvey;
        this.theme = theme;
        this.status = status;
        this.question = question;
    }

    public Survey(String theme, boolean status, List<Question> question) {
        this.theme = theme;
        this.status = status;
        this.question = question;
    }

    
    


    
   

}
