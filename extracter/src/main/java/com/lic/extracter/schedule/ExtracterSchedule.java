package com.lic.extracter.schedule;

import java.util.Calendar;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.lic.extracter.domain.Gatekeeper;
import com.lic.extracter.domain.Sourcer;
import com.lic.extracter.service.ExtracterService;
import com.lic.extracter.service.GatekeeperService;
import com.lic.extracter.service.InserterService;
import com.lic.extracter.service.SourcerService;
import com.lic.extracter.util.ApplicationUtils;

@Component("extracterSchedule")
public class ExtracterSchedule {
	private static Logger log = Logger.getLogger(ExtracterSchedule.class);
	
	private static AtomicInteger count = new AtomicInteger(0);
	
	@Autowired
	private InserterService inserterService;
	
	@Autowired
	private SourcerService sourcerService; 
	
	@Autowired
	private ExtracterService extracterService;
	
	private Gatekeeper gatekeeper = null;
	
	@Autowired
	private GatekeeperService gatekeeperService;
	
	private void init(){
		if(gatekeeper == null){
			List<Gatekeeper> gatekeepers = gatekeeperService.findAllGatekeepers();
			for(Gatekeeper gatekeeper : gatekeepers){
				if(gatekeeperService.isActive(gatekeeper)){
					if(gatekeeperService.isToday(gatekeeper)){
						this.gatekeeper = gatekeeper;
						return;
					} else {
						gatekeeperService.inactivate(gatekeeper);
						gatekeeperService.updateGatekeeper(gatekeeper);
					}
				}
			}
			this.gatekeeper = gatekeeperService.createFreshGatekeeper();
			gatekeeperService.saveGatekeeper(gatekeeper);
		} 
	}
	
	private void update(int count){
		this.gatekeeper.add(count);
		gatekeeperService.updateGatekeeper(gatekeeper);
	}

	public void populateUrl(){
		inserterService.populateSources("http://www.techspot.com", "test.txt");
	}
	
	public void calculateUrl(){
		init();
		log.info("starting to process count "+count);
		List<Sourcer> sourcers = sourcerService.findSourcerEntries(count.getAndIncrement(), 1);
		
		for(Sourcer sourcer : sourcers){
			int serviceInteractionCount = extracterService.extractKeywords(sourcer.getUrlSource());
			if(!sourcer.getProcessed() && serviceInteractionCount != 0){
				sourcer.setProcessed(true);
				sourcerService.updateSourcer(sourcer);
				log.info("count "+count+" processed "+sourcer.getUrlSource());
				update(serviceInteractionCount);
			} else {
				log.info("count "+count+" was processed!");
			}
		}
	}
	
	public void calculateExtraUrl(){
		init();
		log.info("starting to process count "+count);
		List<Sourcer> sourcers = sourcerService.findSourcerEntries(count.getAndIncrement(), 1);
		
		for(Sourcer sourcer : sourcers){
			int serviceInteractionCount = extracterService.extractExtra(sourcer.getUrlSource());
			if(!sourcer.getProcessed() && serviceInteractionCount != 0){
				sourcer.setProcessed(true);
				sourcerService.updateSourcer(sourcer);
				log.info("count "+count+" processed "+sourcer.getUrlSource());
				update(serviceInteractionCount);
			} else {
				log.info("count "+count+" was already processed!");
			}
		}
	}
}
