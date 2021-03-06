// WARNING: DO NOT EDIT THIS FILE. THIS FILE IS MANAGED BY SPRING ROO.
// You may push code into the target .java compilation unit if you wish to edit any member(s).

package com.lic.extracter.service;

import com.lic.extracter.domain.Gatekeeper;
import com.lic.extracter.repository.GatekeeperRepository;
import java.math.BigInteger;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

privileged aspect GatekeeperServiceImpl_Roo_Service {
    
    declare @type: GatekeeperServiceImpl: @Service;
    
    declare @type: GatekeeperServiceImpl: @Transactional;
    
    @Autowired
    GatekeeperRepository GatekeeperServiceImpl.gatekeeperRepository;
    
    public long GatekeeperServiceImpl.countAllGatekeepers() {
        return gatekeeperRepository.count();
    }
    
    public void GatekeeperServiceImpl.deleteGatekeeper(Gatekeeper gatekeeper) {
        gatekeeperRepository.delete(gatekeeper);
    }
    
    public Gatekeeper GatekeeperServiceImpl.findGatekeeper(BigInteger id) {
        return gatekeeperRepository.findOne(id);
    }
    
    public List<Gatekeeper> GatekeeperServiceImpl.findAllGatekeepers() {
        return gatekeeperRepository.findAll();
    }
    
    public List<Gatekeeper> GatekeeperServiceImpl.findGatekeeperEntries(int firstResult, int maxResults) {
        return gatekeeperRepository.findAll(new org.springframework.data.domain.PageRequest(firstResult / maxResults, maxResults)).getContent();
    }
    
    public void GatekeeperServiceImpl.saveGatekeeper(Gatekeeper gatekeeper) {
        gatekeeperRepository.save(gatekeeper);
    }
    
    public Gatekeeper GatekeeperServiceImpl.updateGatekeeper(Gatekeeper gatekeeper) {
        return gatekeeperRepository.save(gatekeeper);
    }
    
}
