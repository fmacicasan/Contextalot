// WARNING: DO NOT EDIT THIS FILE. THIS FILE IS MANAGED BY SPRING ROO.
// You may push code into the target .java compilation unit if you wish to edit any member(s).

package com.lic.extracter.domain;

import com.lic.extracter.domain.GatekeeperDataOnDemand;
import com.lic.extracter.service.GatekeeperService;
import java.math.BigInteger;
import java.util.List;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

privileged aspect GatekeeperIntegrationTest_Roo_IntegrationTest {
    
    declare @type: GatekeeperIntegrationTest: @RunWith(SpringJUnit4ClassRunner.class);
    
    declare @type: GatekeeperIntegrationTest: @ContextConfiguration(locations = "classpath:/META-INF/spring/applicationContext*.xml");
    
    @Autowired
    private GatekeeperDataOnDemand GatekeeperIntegrationTest.dod;
    
    @Autowired
    GatekeeperService GatekeeperIntegrationTest.gatekeeperService;
    
    @Test
    public void GatekeeperIntegrationTest.testCountAllGatekeepers() {
        Assert.assertNotNull("Data on demand for 'Gatekeeper' failed to initialize correctly", dod.getRandomGatekeeper());
        long count = gatekeeperService.countAllGatekeepers();
        Assert.assertTrue("Counter for 'Gatekeeper' incorrectly reported there were no entries", count > 0);
    }
    
    @Test
    public void GatekeeperIntegrationTest.testFindGatekeeper() {
        Gatekeeper obj = dod.getRandomGatekeeper();
        Assert.assertNotNull("Data on demand for 'Gatekeeper' failed to initialize correctly", obj);
        BigInteger id = obj.getId();
        Assert.assertNotNull("Data on demand for 'Gatekeeper' failed to provide an identifier", id);
        obj = gatekeeperService.findGatekeeper(id);
        Assert.assertNotNull("Find method for 'Gatekeeper' illegally returned null for id '" + id + "'", obj);
        Assert.assertEquals("Find method for 'Gatekeeper' returned the incorrect identifier", id, obj.getId());
    }
    
    @Test
    public void GatekeeperIntegrationTest.testFindAllGatekeepers() {
        Assert.assertNotNull("Data on demand for 'Gatekeeper' failed to initialize correctly", dod.getRandomGatekeeper());
        long count = gatekeeperService.countAllGatekeepers();
        Assert.assertTrue("Too expensive to perform a find all test for 'Gatekeeper', as there are " + count + " entries; set the findAllMaximum to exceed this value or set findAll=false on the integration test annotation to disable the test", count < 250);
        List<Gatekeeper> result = gatekeeperService.findAllGatekeepers();
        Assert.assertNotNull("Find all method for 'Gatekeeper' illegally returned null", result);
        Assert.assertTrue("Find all method for 'Gatekeeper' failed to return any data", result.size() > 0);
    }
    
    @Test
    public void GatekeeperIntegrationTest.testFindGatekeeperEntries() {
        Assert.assertNotNull("Data on demand for 'Gatekeeper' failed to initialize correctly", dod.getRandomGatekeeper());
        long count = gatekeeperService.countAllGatekeepers();
        if (count > 20) count = 20;
        int firstResult = 0;
        int maxResults = (int) count;
        List<Gatekeeper> result = gatekeeperService.findGatekeeperEntries(firstResult, maxResults);
        Assert.assertNotNull("Find entries method for 'Gatekeeper' illegally returned null", result);
        Assert.assertEquals("Find entries method for 'Gatekeeper' returned an incorrect number of entries", count, result.size());
    }
    
    @Test
    public void GatekeeperIntegrationTest.testSaveGatekeeper() {
        Assert.assertNotNull("Data on demand for 'Gatekeeper' failed to initialize correctly", dod.getRandomGatekeeper());
        Gatekeeper obj = dod.getNewTransientGatekeeper(Integer.MAX_VALUE);
        Assert.assertNotNull("Data on demand for 'Gatekeeper' failed to provide a new transient entity", obj);
        Assert.assertNull("Expected 'Gatekeeper' identifier to be null", obj.getId());
        gatekeeperService.saveGatekeeper(obj);
        Assert.assertNotNull("Expected 'Gatekeeper' identifier to no longer be null", obj.getId());
    }
    
    @Test
    public void GatekeeperIntegrationTest.testDeleteGatekeeper() {
        Gatekeeper obj = dod.getRandomGatekeeper();
        Assert.assertNotNull("Data on demand for 'Gatekeeper' failed to initialize correctly", obj);
        BigInteger id = obj.getId();
        Assert.assertNotNull("Data on demand for 'Gatekeeper' failed to provide an identifier", id);
        obj = gatekeeperService.findGatekeeper(id);
        gatekeeperService.deleteGatekeeper(obj);
        Assert.assertNull("Failed to remove 'Gatekeeper' with identifier '" + id + "'", gatekeeperService.findGatekeeper(id));
    }
    
}
