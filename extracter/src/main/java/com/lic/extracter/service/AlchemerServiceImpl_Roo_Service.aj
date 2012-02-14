// WARNING: DO NOT EDIT THIS FILE. THIS FILE IS MANAGED BY SPRING ROO.
// You may push code into the target .java compilation unit if you wish to edit any member(s).

package com.lic.extracter.service;

import com.lic.extracter.domain.Alchemer;
import com.lic.extracter.repository.AlchemerRepository;
import java.math.BigInteger;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

privileged aspect AlchemerServiceImpl_Roo_Service {
    
    declare @type: AlchemerServiceImpl: @Service;
    
    declare @type: AlchemerServiceImpl: @Transactional;
    
    @Autowired
    AlchemerRepository AlchemerServiceImpl.alchemerRepository;
    
    public long AlchemerServiceImpl.countAllAlchemers() {
        return alchemerRepository.count();
    }
    
    public void AlchemerServiceImpl.deleteAlchemer(Alchemer alchemer) {
        alchemerRepository.delete(alchemer);
    }
    
    public Alchemer AlchemerServiceImpl.findAlchemer(BigInteger id) {
        return alchemerRepository.findOne(id);
    }
    
    public List<Alchemer> AlchemerServiceImpl.findAllAlchemers() {
        return alchemerRepository.findAll();
    }
    
    public List<Alchemer> AlchemerServiceImpl.findAlchemerEntries(int firstResult, int maxResults) {
        return alchemerRepository.findAll(new org.springframework.data.domain.PageRequest(firstResult / maxResults, maxResults)).getContent();
    }
    
    public void AlchemerServiceImpl.saveAlchemer(Alchemer alchemer) {
        alchemerRepository.save(alchemer);
    }
    
    public Alchemer AlchemerServiceImpl.updateAlchemer(Alchemer alchemer) {
        return alchemerRepository.save(alchemer);
    }
    
}
