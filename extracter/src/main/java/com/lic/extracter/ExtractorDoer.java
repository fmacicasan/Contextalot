package com.lic.extracter;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class ExtractorDoer {
	public static void main(String[] args){
		ClassPathXmlApplicationContext appContext = new ClassPathXmlApplicationContext(
		        new String[] {"classpath:/META-INF/spring/applicationContext*.xml"});
		// of course, an ApplicationContext is just a BeanFactory
		BeanFactory factory = (BeanFactory) appContext;
		
		while(true){
			
		}
	}
}
