package com.lic.extracter.domain;

import org.springframework.roo.addon.javabean.RooJavaBean;
import org.springframework.roo.addon.layers.repository.mongo.RooMongoEntity;
import org.springframework.roo.addon.tostring.RooToString;

@RooJavaBean
@RooToString
@RooMongoEntity
public class Gatekeeper {
	private String date;
	private Integer count;
	private Boolean active;
	
	public void increment(){
		this.count++;
	}
}
