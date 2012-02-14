package com.lic.extracter.service;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.Calendar;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lic.extracter.alchemy.AlchemyWSInvoker;
import com.lic.extracter.domain.Alchemer;
import com.lic.extracter.domain.ExtraAlchemer;
import com.lic.extracter.exception.ExtracterException;
import com.lic.extracter.util.ApplicationUtils;

@Service
public class ExtracterService {
	private static Logger log = Logger.getLogger(ExtracterService.class);
	
	@Autowired
	private AlchemyWSInvoker alchemyWSInvoker;
	
	@Autowired
	private AlchemerService alchemerService;
	
	@Autowired
	private ApplicationUtils applicationUtils;
	
	@Autowired
	private ExtraAlchemerService extraAlchemerService ;
	
	public boolean extractKeywords(String url){
		
		try {
			URL goodUrl = new URL(url);
			
			String urlContent = applicationUtils.readPage(goodUrl);
			
			String keywords = alchemyWSInvoker.extractKeywords(url);

			
			Alchemer alchemer = new Alchemer();
			alchemer.setKeywords(keywords);
			alchemer.setInquiryDate(applicationUtils.printLongDate(Calendar.getInstance()));
			alchemer.setUrl(url);
			alchemer.setUrlContent(urlContent);
			
			alchemerService.saveAlchemer(alchemer);
			
			return true;
			
		} catch (MalformedURLException e) {
			log.error("Mallformed URL",e);
			return false;
		} catch (ExtracterException e) {
			log.error("Extracter exception at extract keywords",e);
			return false;
		} 
	}
	
	public boolean extractExtra(String url){
		try {
			URL goodUrl = new URL(url);
			
			String urlContent = applicationUtils.readPage(goodUrl);
			
			String keywords = alchemyWSInvoker.extractKeywords(url);
			String category = alchemyWSInvoker.extractCategory(url);
			String namedEntities = alchemyWSInvoker.extractNamedEntities(url);
		    String relations = alchemyWSInvoker.extractRelations(url);
		    //String title = alchemyWSInvoker.extractTitle(url);
		    //String text = alchemyWSInvoker.extractTitle(url);
			
			ExtraAlchemer extraAlchemer = new ExtraAlchemer();
			extraAlchemer.setKeywords(keywords);
			extraAlchemer.setInquiryDate(applicationUtils.printLongDate(Calendar.getInstance()));
			extraAlchemer.setUrl(url);
			extraAlchemer.setUrlContent(urlContent);
			extraAlchemer.setCategory(category);
			extraAlchemer.setNamedEntities(namedEntities);
			extraAlchemer.setRelations(relations);
			
			extraAlchemerService.saveExtraAlchemer(extraAlchemer);
			
			return true;
			
		} catch (MalformedURLException e) {
			log.error("Mallformed URL",e);
			return false;
		} catch (ExtracterException e) {
			log.error("Extracter exception at extract keywords",e);
			return false;
		} 
	}
}
