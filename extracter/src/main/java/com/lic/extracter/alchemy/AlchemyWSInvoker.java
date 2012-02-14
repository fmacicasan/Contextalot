package com.lic.extracter.alchemy;

import java.util.HashMap;
import java.util.Map;

import com.lic.extracter.exception.ExtracterException;
import com.lic.extracter.repository.AlchemerRepository;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;



@Service
public class AlchemyWSInvoker {
	
	private static Logger log = Logger.getLogger(AlchemyWSInvoker.class);
	
	public static String KEYWORD_PATTERN = "http://access.alchemyapi.com/calls/url/URLGetRankedKeywords?apikey={apikey}&url={url}";
	public static String CATEGORY_PATTERN = "http://access.alchemyapi.com/calls/url/URLGetCategory?apikey={apikey}&url={url}";
	public static String NAMED_ENTITIES_PATTERN = "http://access.alchemyapi.com/calls/url/URLGetRankedNamedEntities?apikey={apikey}&url={url}";
	public static String RELATIONS_PATTERN = "http://access.alchemyapi.com/calls/url/URLGetRelations?apikey={apikey}&url={url}";
	public static String TITLE_PATTERN = "http://access.alchemyapi.com/calls/url/URLGetTitle?apikey={apikey}&url={url}";
	public static String TEXT_PATTERN = "http://access.alchemyapi.com/calls/url/URLGetText?apikey={apikey}&url={url}";
	
	@Autowired
	private AlchemyCredential alchemyCredential;

    @Autowired
    private RestTemplate restTemplate;
	
    public String extractKeywords(String url) throws ExtracterException{
    	log.info("Extracting keywords"+ "from "+url);
    	return extract(url,KEYWORD_PATTERN);
    }
    
    public String extractCategory(String url) throws ExtracterException{
    	log.info("Extracting category"+ "from "+url);
    	return extract(url,CATEGORY_PATTERN);
    }
    
    public String extractNamedEntities(String url) throws ExtracterException{
    	log.info("Extracting named entities"+ "from "+url);
    	return extract(url,NAMED_ENTITIES_PATTERN);
    }
    
    public String extractRelations(String url) throws ExtracterException{
    	log.info("Extracting relations"+ "from "+url);
    	return extract(url,RELATIONS_PATTERN);
    }
    
    public String extractTitle(String url) throws ExtracterException {
    	log.info("Extracting title"+ "from "+url);
    	return extract(url, TITLE_PATTERN);
    }
    
    public String extractText(String url) throws ExtracterException {
    	log.info("Extracting text"+ "from "+url);
    	return extract(url, TEXT_PATTERN);
    }
    
	private String extract(String url,String pattern) throws ExtracterException{
		try{	
			Map<String,String> params = new HashMap<String,String>();
			params.put("apikey", alchemyCredential.getAlchemyApiKey());
			params.put("url", url);
			
			String result = restTemplate.getForObject(pattern,String.class,params);
			log.info("extraction successful from url "+url);
			return result;
		}catch(RestClientException e){
			log.error("issue at extraction",e);
			throw new ExtracterException(e);
		}
	}

}
