/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
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
