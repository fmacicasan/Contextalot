package com.lic.extracter.service;

import java.util.Calendar;

import org.springframework.roo.addon.layers.service.RooService;

import com.lic.extracter.domain.Gatekeeper;

@RooService(domainTypes = { com.lic.extracter.domain.Gatekeeper.class })
public interface GatekeeperService {
	
	public boolean isToday(Gatekeeper gatekeeper);
	
	public void inactivate(Gatekeeper gatekeeper);
	
	public boolean isActive(Gatekeeper gatekeeper);
	
	public  Gatekeeper createFreshGatekeeper();
}
