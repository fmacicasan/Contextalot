package com.lic.extracter.domain;

import java.util.Calendar;

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
	private Calendar timestamp;
	
	public void increment(){
		this.count++;
	}

	public void add(int count2) {
		this.count += count2;
	}
}
