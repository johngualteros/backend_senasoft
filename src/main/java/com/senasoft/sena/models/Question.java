package com.senasoft.sena.models;

import java.sql.Date;
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
@Table()
public class Question {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idquestion;

    @Column(name = "statement")
    private String statement;

    @Column(name = "opendate", nullable = false)
    private String openingdate;

    @Column(name = "closingdate", nullable = false)
    private String closingdate;

    @Column(name = "state", nullable = false)
    private Boolean state = false; 

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "response_id")
    private List<Response> response;

    public Question() {
    }

    public long getIdquestion() {
        return idquestion;
    }

    public void setIdquestion(long idquestion) {
        this.idquestion = idquestion;
    }

    public String getStatement() {
        return statement;
    }

    public void setStatement(String statement) {
        this.statement = statement;
    }

    public String getOpeningdate() {
        return openingdate;
    }

    public void setOpeningdate(String openingdate) {
        this.openingdate = openingdate;
    }

    public String getClosingdate() {
        return closingdate;
    }

    public void setClosingdate(String closingdate) {
        this.closingdate = closingdate;
    }

    public Boolean getState() {
        return state;
    }

    public void setState(Boolean state) {
        this.state = state;
    }

    public List<Response> getResponse() {
        return response;
    }

    public void setResponse(List<Response> response) {
        this.response = response;
    }


    

    
}
