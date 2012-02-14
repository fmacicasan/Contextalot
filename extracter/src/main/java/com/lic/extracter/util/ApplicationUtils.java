package com.lic.extracter.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.Calendar;

import org.springframework.core.io.UrlResource;
import org.springframework.stereotype.Component;

import com.lic.extracter.exception.ExtracterException;

@Component("applicationUtils")
public class ApplicationUtils {

	public String readPage(URL url) throws ExtracterException{
		InputStream is;
		try {
			UrlResource res = new UrlResource(url);
			 is = res.getInputStream();
			
			 BufferedReader in = new BufferedReader(new InputStreamReader(is));
			 String inputLine;
			 StringBuilder sb = new StringBuilder();
			 
			 while ((inputLine = in.readLine()) != null){
				 sb.append(inputLine);
			 }
			
			in.close();
			
			return sb.toString();
			
		} catch (IOException e) {
			throw new ExtracterException("invalid url for page");
		} 	     
	}
	
	public String printLongDate(Calendar date){
		return String.format("%1$tF %1$tY %1$tT,%1$tL", date);
	}
}
