package com.lic.extracter.alchemy;

import org.springframework.roo.addon.javabean.RooJavaBean;
import org.springframework.roo.addon.tostring.RooToString;

@RooJavaBean
@RooToString
public class AlchemyCredential {
	
	private String alchemyApiKey;

	public AlchemyCredential(String alchemyApiKey) {
		this.alchemyApiKey = alchemyApiKey;
	}
	
}
