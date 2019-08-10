/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.demoonetomany.model.serviceimpl;

import com.mycompany.demoonetomany.model.Proposal;
import com.mycompany.demoonetomany.model.service.ProposalService;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

/**
 *
 * @author dhruv
 */
public class ProposalServiceImpl implements ProposalService {

    private final EntityManagerFactory factory;
    private final EntityManager em;
    private final String PERSISTENCE_UNIT_NAME = "UNIT";
    private static final Logger LOG = Logger.getLogger(ProposalServiceImpl.class.getName());

    public ProposalServiceImpl() {
        factory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
        em = factory.createEntityManager();
    }

    @Override
    public void addProposal(Proposal proposal) {

        try {
            em.getTransaction().begin();
            em.persist(proposal);
            em.getTransaction().commit();

        } catch (Exception e) {
            LOG.info(e.getMessage());
        }

    }

    @Override
    public List<Proposal> retrieveProposal() {
        TypedQuery<Proposal> q = em.createQuery("select u FROM Proposal u", Proposal.class);
        List<Proposal> results = q.getResultList();
        return results;
    }

    @Override
    public void deleteProposal(Long id) {
        try {
            em.getTransaction().begin();
            Proposal p = em.find(Proposal.class, id);
            em.remove(p);
            em.getTransaction().commit();
        } catch (Exception e) {
            LOG.info(e.getMessage());
        }

    }

    @Override
    public void updateProposal(Long id) {
        try {
            em.getTransaction().begin();
            String title="updated proposal";
            String comment="comment updated";
            
            
            Query query = em.createQuery("UPDATE Proposal c SET c.title  = ?1 ,c.comment= ?2 WHERE c.docId=?3");
            query.setParameter(1,title);
            query.setParameter(2,comment);
            query.setParameter(3,id);
            
            int updateCount = query.executeUpdate();
            LOG.log(Level.INFO, "row updated", updateCount);
            em.getTransaction().commit();
        } catch (Exception e) {
            LOG.info(e.getMessage());
        }

    }

}
