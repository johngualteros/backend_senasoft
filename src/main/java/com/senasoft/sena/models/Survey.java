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

<<<<<<< HEAD
    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "surkey_id")
    private List<Certification> certification;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "surkey_id")
    private List<Question> question;


=======
>>>>>>> 66aa4eb74364675de89a08512bc37bd82a54a52d
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
    public List<Certification> getCertification() {
            return certification;
        }

<<<<<<< HEAD
        public void setCertification(List<Certification> certification) {
            this.certification = certification;
        }

        public List<Question> getQuestion() {
            return question;
        }

        public void setQuestion(List<Question> question) {
            this.question = question;
        }


    public Survey() {
    }

    public Survey(Long idsurvey, String theme, List<Certification> certification, List<Question> question) {
        this.idsurvey = idsurvey;
        this.theme = theme;
        this.certification = certification;
        this.question = question;
    }

    public Survey(String theme, List<Certification> certification, List<Question> question) {
        this.theme = theme;
        this.certification = certification;
        this.question = question;
    }

    
   

}
