package com.mycompany.demoonetomany.model;

import java.sql.Timestamp;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import org.apache.commons.lang.builder.ReflectionToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

/**
 *
 * @author dhruv
 */
@Entity
@Table(name = "attachment")
public class Attachment {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "SEQUENCE1")
    @SequenceGenerator(name = "SEQUENCE1", sequenceName = "attachment_id_seq", allocationSize = 1)
    private Long attachmentId;
    @Column(name = "filename")
    private String filename;
    @Column(name = "filesize")
    private String fileSize;
    @Column(name = "created")
    private Timestamp created;
    @Column(name = "attachment_bytes")
    private byte[] attachmentBytes;

//    @OneToOne(cascade = CascadeType.ALL)
//    private Personnel personnel;
//
//    @OneToOne(cascade = CascadeType.ALL)
//    private Proposal proposal;

    public Attachment() {
    }


    public Attachment(String filename, String fileSize, Timestamp created, byte[] attachmentBytes) {
        this.filename = filename;
        this.fileSize = fileSize;
        this.created = created;
        this.attachmentBytes = attachmentBytes;
    }

    public Long getAttachmentId() {
        return attachmentId;
    }

    public void setAttachmentId(Long attachmentId) {
        this.attachmentId = attachmentId;
    }

    public String getFilename() {
        return filename;
    }

    public void setFilename(String filename) {
        this.filename = filename;
    }

    public String getFileSize() {
        return fileSize;
    }

    public void setFileSize(String fileSize) {
        this.fileSize = fileSize;
    }

    public Timestamp getCreated() {
        return created;
    }

    public void setCreated(Timestamp created) {
        this.created = created;
    }

    public byte[] getAttachmentBytes() {
        return attachmentBytes;
    }

    public void setAttachmentBytes(byte[] attachmentBytes) {
        this.attachmentBytes = attachmentBytes;
    }


    @Override
    public String toString() {
        return ReflectionToStringBuilder.toString(this, ToStringStyle.MULTI_LINE_STYLE);

    }

}
