package com.mycompany.demoonetomany.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import org.apache.commons.lang.builder.ReflectionToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

/**
 *
 * @author dhruv
 */
@Entity
@Table(name = "personnel")
public class Personnel {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "SEQUENCE1")
    @SequenceGenerator(name = "SEQUENCE1", sequenceName = "personnel_id_seq", allocationSize = 1)
    private Long id;
    @Column(name = "name", length = 60)
    private String name;

    @Enumerated(EnumType.STRING)
    @Column(name = "qualificationlevel")
    private QualificationLevel.Level qualificationLevel;

    @Column(name = "phone", length = 10)
    @Size(min = 10, max = 10)
    private String phone;

//    @OneToMany(cascade = CascadeType.ALL)
//    @JoinColumn(name = "attachmentId_mappedTo_Personnel", referencedColumnName = "id")
//    private Set<Attachment> attachment;
    public Personnel() {
    }

    public Personnel(String name, QualificationLevel.Level level, String phone) {
        this.name = name;
        this.qualificationLevel = level;
        this.phone = phone;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public QualificationLevel.Level getQualificationLevel() {
        return qualificationLevel;
    }

    public void setQualificationLevel(QualificationLevel.Level qualificationLevel) {
        this.qualificationLevel = qualificationLevel;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    @Override
    public String toString() {
        return ReflectionToStringBuilder.toString(this, ToStringStyle.MULTI_LINE_STYLE);

    }
}
