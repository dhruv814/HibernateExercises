package com.mycompany.demoonetomany.model.service;

import com.mycompany.demoonetomany.model.Proposal;
import java.util.List;

/**
 *
 * @author dhruv
 */
public interface ProposalService {
    void addProposal(Proposal proposal);
    List<Proposal> retrieveProposal();
    void deleteProposal(Long id);
    void updateProposal(Long id);
    
}
