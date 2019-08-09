/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.demoonetoone;

import java.util.function.Supplier;
import java.util.logging.Logger;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author dhruv
 */
public class AppMain {

    private static EntityManagerFactory factory;
    private static EntityManager em1;
    private static final String PERSISTENCE_UNIT_NAME = "UNIT";

    public static void main(String[] args) {
        //Logger logger = Logger.getLogger(AppMain.class.getName());
        factory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
        em1 = factory.createEntityManager();

        Education edu = new Education("B.Tech", "Engineering", "2019", "BVM");
        Address add = new Address("s1", "s2", "borsad", "anand", "c1", "india");

        Student student = new Student("dhruv", "mukeshbhai", "patel", "Mr", "Ph.D", "d@xyz.com", "9898787854", add, edu);

        try {
            em1.getTransaction().begin();
            em1.persist(student);
            em1.getTransaction().commit();

        } catch (Exception e) {
            System.out.println(e);
            //logger.info((Supplier<String>) e);
        }

    }
}
