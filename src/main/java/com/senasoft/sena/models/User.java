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
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.springframework.boot.context.properties.bind.DefaultValue;

@Entity
@Table
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idusuario;

    @Column(name = "numberdocument", length = 15)
    private String numberdocument;

    @Column(name = "name", length = 50, nullable = false)
    private String name;

    @Column(name = "lastname", length = 50, nullable = false)
    private String lastname;

    @Column(name = "address", length = 50, nullable = false)
    private String address;

    @Column(name = "email", length = 50, nullable = false)
    private String email;

    @Column(name = "numberphone", length = 13, nullable = false)
    private String numberphone;

    @Column(name = "landline", length = 10, nullable = false)
    private String landline;

    @Column(name = "datebirth", nullable = false)
    private Date datebirth;

    @Column(name = "municipality", length = 30, nullable = false)
    private String municipality;

    @Column(name = "stratum", length = 15, nullable = false)
    private String stratum;

    @Column(name = "academiclevel", length = 30, nullable = false)
    private String academiclevel;

    @Column(name = "sex", length = 18, nullable = false)
    private String sex;

    @Column(name = "affiliationregime", length = 30, nullable = false)
    private String affiliationregime;

    @Column(name = "disabilitycondition", length = 40, nullable = false)
    private String disabilitycondition;

    @Column(name = "ethnicity", length = 20, nullable = false)
    private String ethnicity;

    @Column(name = "technologicalaccess", length = 4, nullable = false)
    private String technologicalaccess;

    @Column(name = "role", length = 20, nullable = false)
    private String role = "citizen";

    @Column(name = "password", length = 20, nullable = false)
    private String password;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "survey_id")
    private List<Survey> survey;

    public Long getIdusuario() {
        return idusuario;
    }

    public void setIdusuario(Long idusuario) {
        this.idusuario = idusuario;
    }

    public String getNumberdocument() {
        return numberdocument;
    }

    public void setNumberdocument(String numberdocument) {
        this.numberdocument = numberdocument;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNumberphone() {
        return numberphone;
    }

    public void setNumberphone(String numberphone) {
        this.numberphone = numberphone;
    }

    public String getLandline() {
        return landline;
    }

    public void setLandline(String landline) {
        this.landline = landline;
    }

    public Date getDatebirth() {
        return datebirth;
    }

    public void setDatebirth(Date datebirth) {
        this.datebirth = datebirth;
    }

    public String getMunicipality() {
        return municipality;
    }

    public void setMunicipality(String municipality) {
        this.municipality = municipality;
    }

    public String getStratum() {
        return stratum;
    }

    public void setStratum(String stratum) {
        this.stratum = stratum;
    }

    public String getAcademiclevel() {
        return academiclevel;
    }

    public void setAcademiclevel(String academiclevel) {
        this.academiclevel = academiclevel;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getAffiliationregime() {
        return affiliationregime;
    }

    public void setAffiliationregime(String affiliationregime) {
        this.affiliationregime = affiliationregime;
    }

    public String getDisabilitycondition() {
        return disabilitycondition;
    }

    public void setDisabilitycondition(String disabilitycondition) {
        this.disabilitycondition = disabilitycondition;
    }

    public String getEthnicity() {
        return ethnicity;
    }

    public void setEthnicity(String ethnicity) {
        this.ethnicity = ethnicity;
    }

    public String getTechnologicalaccess() {
        return technologicalaccess;
    }

    public void setTechnologicalaccess(String technologicalaccess) {
        this.technologicalaccess = technologicalaccess;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<Survey> getSurvey() {
        return survey;
    }

    public void setSurvey(List<Survey> survey) {
        this.survey = survey;
    }

    
    public User(Long idusuario, String numberdocument, String name, String lastname, String address, String email,
            String numberphone, String landline, Date datebirth, String municipality, String stratum,
            String academiclevel, String sex, String affiliationregime, String disabilitycondition, String ethnicity,
            String technologicalaccess, String role, String password, List<Survey> survey) {
        this.idusuario = idusuario;
        this.numberdocument = numberdocument;
        this.name = name;
        this.lastname = lastname;
        this.address = address;
        this.email = email;
        this.numberphone = numberphone;
        this.landline = landline;
        this.datebirth = datebirth;
        this.municipality = municipality;
        this.stratum = stratum;
        this.academiclevel = academiclevel;
        this.sex = sex;
        this.affiliationregime = affiliationregime;
        this.disabilitycondition = disabilitycondition;
        this.ethnicity = ethnicity;
        this.technologicalaccess = technologicalaccess;
        this.role = role;
        this.password = password;
        this.survey = survey;
    }

    
    public User(String numberdocument, String name, String lastname, String address, String email, String numberphone,
            String landline, Date datebirth, String municipality, String stratum, String academiclevel, String sex,
            String affiliationregime, String disabilitycondition, String ethnicity, String technologicalaccess,
            String role, String password, List<Survey> survey) {
        this.numberdocument = numberdocument;
        this.name = name;
        this.lastname = lastname;
        this.address = address;
        this.email = email;
        this.numberphone = numberphone;
        this.landline = landline;
        this.datebirth = datebirth;
        this.municipality = municipality;
        this.stratum = stratum;
        this.academiclevel = academiclevel;
        this.sex = sex;
        this.affiliationregime = affiliationregime;
        this.disabilitycondition = disabilitycondition;
        this.ethnicity = ethnicity;
        this.technologicalaccess = technologicalaccess;
        this.role = role;
        this.password = password;
        this.survey = survey;
    }

    public User() {
    }

    
}
