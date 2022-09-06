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
public class Cuestion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idquestion;

    @Column(name = "statement")
    private String statement;

    @Column(name = "opindate", nullable = false)
    private Date openingdate;

    @Column(name = "clogindate", nullable = false)
    private Date closingdate;

    @Column(name = "state", nullable = false)
    private Boolean state; 

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "university_id")
    private List<Certification> certification;

    public Cuestion() {
    }


    public Cuestion(long idquestion, String statement, Date openingdate, Date closingdate, Boolean state,
            List<Certification> certification) {
        this.idquestion = idquestion;
        this.statement = statement;
        this.openingdate = openingdate;
        this.closingdate = closingdate;
        this.state = state;
        this.certification = certification;
    }

    public Cuestion(String statement, Date openingdate, Date closingdate, Boolean state,
            List<Certification> certification) {
        this.statement = statement;
        this.openingdate = openingdate;
        this.closingdate = closingdate;
        this.state = state;
        this.certification = certification;
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

    public List<Certification> getCertification() {
        return certification;
    }

    public void setCertification(List<Certification> certification) {
        this.certification = certification;
    }


    
}
