package com.mycompany.hibernatedemo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

/**
 *
 * @author dhruv
 */
@Entity
@Table(name = "helloworld")
public class HelloWorld {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "SEQUENCE1")
    @SequenceGenerator(name = "SEQUENCE1", sequenceName = "HelloWorld_id_seq", allocationSize = 1)
    @Column(name = "id")
    private int id;

    @Column(name = "message")
    private String message;

    public HelloWorld() {
    }

    public HelloWorld(int id, String message) {
        this.id = id;
        this.message = message;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return "User{" + "id=" + id + ", message=" + message + '}';
    }

}
