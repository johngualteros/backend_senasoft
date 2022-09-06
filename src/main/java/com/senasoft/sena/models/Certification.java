package com.senasoft.sena.models;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import net.bytebuddy.implementation.bind.annotation.Empty;

@Entity
@Table()
public class Certification {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idcertification;

    @Column(name = "certification", length = 255, nullable = false)
    private long settled;

    @Column(name = "certificationdate")
    private Date certificationdate;

    

    public Certification() {
    }



    public Certification(long idcertification, long settled, Date certificationdate) {
        this.idcertification = idcertification;
        this.settled = settled;
        this.certificationdate = certificationdate;
    }

    

    public Certification(long settled, Date certificationdate) {
        this.settled = settled;
        this.certificationdate = certificationdate;
    }



    public long getIdcertification() {
        return idcertification;
    }

    public void setIdcertification(long idcertification) {
        this.idcertification = idcertification;
    }

    public long getSettled() {
        return settled;
    }

    public void setSettled(long settled) {
        this.settled = settled;
    }

    public Date getCertificationdate() {
        return certificationdate;
    }

    public void setCertificationdate(Date certificationdate) {
        this.certificationdate = certificationdate;
    }
    
    

}
