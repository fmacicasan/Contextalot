// WARNING: DO NOT EDIT THIS FILE. THIS FILE IS MANAGED BY SPRING ROO.
// You may push code into the target .java compilation unit if you wish to edit any member(s).

package com.lic.extracter.domain;

import java.math.BigInteger;
import javax.persistence.Entity;
import org.springframework.data.annotation.Id;

privileged aspect Gatekeeper_Roo_Mongo_Entity {
    
    declare @type: Gatekeeper: @Entity;
    
    @Id
    private BigInteger Gatekeeper.id;
    
    public BigInteger Gatekeeper.getId() {
        return id;
    }
    
    public void Gatekeeper.setId(BigInteger id) {
        this.id = id;
    }
    
}
