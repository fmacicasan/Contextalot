package com.lic.extracter.service;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StopWatch;

import com.lic.extracter.domain.Sourcer;

@Service
public class InserterService {
	
	private static Logger log = Logger.getLogger(InserterService.class);
	
	@Autowired
	private SourcerService service;
	
	public void populateSources(String defaultPrefix, String sourceFile){
		
		try {
			if(!sourceFile.startsWith("/")){
				sourceFile = "/" + sourceFile;
			}
			StopWatch s = new StopWatch();
			InputStream is = InserterService.class.getResourceAsStream(sourceFile);
			DataInputStream in = new DataInputStream(is);
			BufferedReader br = new BufferedReader(new InputStreamReader(in));
			String strline;
			while((strline = br.readLine()) != null){
				if(strline.startsWith("/")){
					Sourcer sourcer = new Sourcer();
					sourcer.setProcessed(false);
					sourcer.setUrlSource(defaultPrefix.concat(strline));
					s.start(strline);
					service.saveSourcer(sourcer);
					s.stop();
					log.info("Sourcer saved "+sourcer + " in "+s.getLastTaskTimeMillis());
				}
			}
			is.close();
		} catch (IOException e) {
			log.error("Invalid read",e);
		}
	}

}
