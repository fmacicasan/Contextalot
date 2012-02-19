package com.lic.extracter.service;

import java.util.Calendar;

import org.springframework.beans.factory.annotation.Autowired;

import com.lic.extracter.domain.Gatekeeper;
import com.lic.extracter.util.ApplicationUtils;


public class GatekeeperServiceImpl implements GatekeeperService {
	
	@Autowired
	private ApplicationUtils applicationUtils;
	
	
	public boolean isToday(Gatekeeper gatekeeper){
		Calendar now = Calendar.getInstance();
		Calendar timestamp = gatekeeper.getTimestamp();
		return now.get(Calendar.DAY_OF_YEAR) == timestamp.get(Calendar.DAY_OF_YEAR) && now.get(Calendar.YEAR) == timestamp.get(Calendar.YEAR);
	}
	
	public void inactivate(Gatekeeper gatekeeper){
		if(gatekeeper.getActive()){
			gatekeeper.setActive(false);
		}
	}
	
	public boolean isActive(Gatekeeper gatekeeper){
		return gatekeeper.getActive();
	}
	
	public  Gatekeeper createFreshGatekeeper(){
		Gatekeeper gatekeeper = new Gatekeeper();
		gatekeeper.setActive(true);
		gatekeeper.setCount(0);
		gatekeeper.setDate(applicationUtils.printLongDate(Calendar.getInstance()));
		return gatekeeper;
		
	}
}
