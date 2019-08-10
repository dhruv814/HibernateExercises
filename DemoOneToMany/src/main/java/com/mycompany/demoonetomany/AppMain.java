package com.mycompany.demoonetomany;

import com.mycompany.demoonetomany.model.Attachment;
import com.mycompany.demoonetomany.model.Personnel;
import com.mycompany.demoonetomany.model.Proposal;
import com.mycompany.demoonetomany.model.QualificationLevel;
import com.mycompany.demoonetomany.model.service.ProposalService;
import com.mycompany.demoonetomany.model.serviceimpl.ProposalServiceImpl;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.logging.Logger;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author dhruv
 */
public class AppMain {

    private static final Logger LOG = Logger.getLogger(AppMain.class.getName());

    private static EntityManagerFactory factory;
    private static EntityManager em;
    private static final String PERSISTENCE_UNIT_NAME = "UNIT";

    public static void main(String[] args) {

        factory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
        em = factory.createEntityManager();

        byte[] bytes = "hello world".getBytes();
        Date date = new Date();
        Personnel p1 = new Personnel("dhruv", QualificationLevel.Level.BEGINNER, "9878987456");
        Personnel p2 = new Personnel("ketan", QualificationLevel.Level.INTERMEDIATE, "9874987456");
        Attachment a1 = new Attachment("a1", "200", new Timestamp(date.getTime()), bytes);
        Attachment a2 = new Attachment("a2", "400", new Timestamp(date.getTime()), bytes);

        List<Personnel> listPersonnels = new ArrayList<>();
        listPersonnels.add(p1);
        listPersonnels.add(p2);
        Set<Attachment> listAttachments = new HashSet<>();
        listAttachments.add(a1);
        listAttachments.add(a2);

        //Proposal proposal1 = new Proposal("proposal2", "comment2", listPersonnels, listAttachments);
        
        
        if (args[0].equals("proposal")) {
            ProposalService proposalService = new ProposalServiceImpl();
            switch (args[1]) {
                case "insert":
                    Proposal proposal = new Proposal("proposal3", "comment3", listPersonnels, listAttachments);
                    proposalService.addProposal(proposal);
                    break;
                case "retrive":
                    LOG.info(proposalService.retrieveProposal().toString());
                    break;
                case "update":
                    proposalService.updateProposal(1L);
                    break;
                case "delete":
                    proposalService.deleteProposal(1L);
                    break; 
            }
        }
    }

}
