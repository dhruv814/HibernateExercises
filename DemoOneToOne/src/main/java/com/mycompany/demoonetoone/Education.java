/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.demoonetoone;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 *
 * @author dhruv
 */
@Entity
@Table(name = "education")
public class Education {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name="deg_type")
    private String degType;
    @Column(name="deg_description")
    private String degDescription;
    @Column(name = "gradution_year")
    private String gradutionYear;
    @Column
    private String school;
    @OneToOne(mappedBy="education")
    private Student student;

    public Education( String degType, String degDescription, String gradutionYear, String school) {
        this.degType = degType;
        this.degDescription = degDescription;
        this.gradutionYear = gradutionYear;
        this.school = school;
    }

    
   

    public String getDegType() {
        return degType;
    }

    public void setDegType(String degType) {
        this.degType = degType;
    }

    public String getDegDescription() {
        return degDescription;
    }

    public void setDegDescription(String degDescription) {
        this.degDescription = degDescription;
    }

    public String getGradutionYear() {
        return gradutionYear;
    }

    public void setGradutionYear(String gradutionYear) {
        this.gradutionYear = gradutionYear;
    }

    public String getSchool() {
        return school;
    }

    public void setSchool(String school) {
        this.school = school;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }
    
    

}
