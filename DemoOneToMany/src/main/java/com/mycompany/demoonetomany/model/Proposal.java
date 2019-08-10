/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.demoonetomany.model;

import java.util.List;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import org.apache.commons.lang.builder.ReflectionToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

/**
 *
 * @author dhruv
 */
@Entity
@Table(name = "proposal")
public class Proposal {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "SEQUENCE1")
    @SequenceGenerator(name = "SEQUENCE1", sequenceName = "proposal_id_seq", allocationSize = 1)
    private Long docId;
    @Column(name = "title", length = 100)
    private String title;
    @Column(name = "comment", length = 1000)
    private String comment;

    @OneToMany(cascade = CascadeType.ALL,orphanRemoval = true)
    //@JoinColumn(name = "personnel_id_mappedTo_proposalId", referencedColumnName = "id")
    private List<Personnel> personnel;

    @OneToMany(cascade = CascadeType.ALL,orphanRemoval = true   )
    //@JoinColumn(name = "attachment_id_mappedTo_proposalId", referencedColumnName = "id")
    private Set<Attachment> attachment;

    public Proposal(String title, String comment, List<Personnel> personnel, Set<Attachment> attachment) {
        this.title = title;
        this.comment = comment;
        this.personnel = personnel;
        this.attachment = attachment;
    }

    public Proposal() {
    }

    public Long getDocId() {
        return docId;
    }

    public void setDocId(Long docId) {
        this.docId = docId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public List<Personnel> getPersonnel() {
        return personnel;
    }

    public void setPersonnel(List<Personnel> personnel) {
        this.personnel = personnel;
    }

    public Set<Attachment> getAttachment() {
        return attachment;
    }

    public void setAttachment(Set<Attachment> attachment) {
        this.attachment = attachment;
    }

    @Override
    public String toString() {
        return ReflectionToStringBuilder.toString(this, ToStringStyle.MULTI_LINE_STYLE);

    }

}
