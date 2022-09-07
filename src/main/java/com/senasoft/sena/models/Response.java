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
@Table(name = "response")
public class Response {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idresponse;

    @Column(name = "response", nullable = false)
    private String response;

    @Column(name = "dateresponse", nullable = false)  
    private Date dateresponse;
    
    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "certification_id")
    private List<Certification> certification;

    public Response() {
    }

    public Response(int idresponse, String response, Date dateresponse) {
        this.idresponse = idresponse;
        this.response = response;
        this.dateresponse = dateresponse;
    }

    
    public Response(String response, Date dateresponse) {
        this.response = response;
        this.dateresponse = dateresponse;
    }

    public int getIdresponse() {
        return idresponse;
    }

    public void setIdresponse(int idresponse) {
        this.idresponse = idresponse;
    }

    public String getResponse() {
        return response;
    }

    public void setResponse(String response) {
        this.response = response;
    }

    public Date getDateresponse() {
        return dateresponse;
    }

    public void setDateresponse(Date dateresponse) {
        this.dateresponse = dateresponse;
    }

    

}
