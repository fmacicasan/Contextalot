package com.lic.extracter.domain;

import org.springframework.roo.addon.javabean.RooJavaBean;
import org.springframework.roo.addon.layers.repository.mongo.RooMongoEntity;
import org.springframework.roo.addon.tostring.RooToString;

@RooJavaBean
@RooToString
@RooMongoEntity
public class ExtraAlchemer {
	
	private String url;

    private String inquiryDate;

    private String urlContent;
    
    private String keywords;
    
    private String category;
    private String namedEntities;
    private String relations ;
    
}
