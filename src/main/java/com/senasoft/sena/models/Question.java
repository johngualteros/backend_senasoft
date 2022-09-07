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

    @Column(name = "openingdate", nullable = false)
    private Date openingdate;

    @Column(name = "closingdate", nullable = false)
    private Date closingdate;

    @Column(name = "state", nullable = false)
    private Boolean state; 

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "response_id")
    private List<Response> response;

    public Question() {
    }

    

    public Question(long idquestion, String statement, Date openingdate, Date closingdate, Boolean state,
            List<Response> response) {
        this.idquestion = idquestion;
        this.statement = statement;
        this.openingdate = openingdate;
        this.closingdate = closingdate;
        this.state = state;
        this.response = response;
    }

    public Question(String statement, Date openingdate, Date closingdate, Boolean state, List<Response> response) {
        this.statement = statement;
        this.openingdate = openingdate;
        this.closingdate = closingdate;
        this.state = state;
        this.response = response;
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

    public Date getOpeningdate() {
        return openingdate;
    }

    public void setOpeningdate(Date openingdate) {
        this.openingdate = openingdate;
    }

    public Date getClosingdate() {
        return closingdate;
    }

    public void setClosingdate(Date closingdate) {
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
