package com.lic.extracter.alchemy;

/**
 * @author Flopi
 */

import static org.junit.Assert.*;
import static org.junit.Assert.assertEquals;

import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.lic.extracter.exception.ExtracterException;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:/META-INF/spring/applicationContext*.xml")
@Configurable
public class AlchemyWSInvokerTest {

    @Autowired
    private AlchemyWSInvoker alchemyWSInvoker;
    
    @Test
    public void extractKeywordsTest(){
		try {
			DataInputStream dis = new DataInputStream (AlchemyWSInvokerTest.class.getResourceAsStream("/expectedKeywords.xml"));
		
     
    		 byte[] datainBytes = new byte[dis.available()];
    		 dis.readFully(datainBytes);
    		 dis.close();
     
    		 String content = new String(datainBytes, 0, datainBytes.length);
    		 
    		 String result = alchemyWSInvoker.extractKeywords("http://www.cnn.com/2009/CRIME/01/13/missing.pilot/index.html");
    		 assertTrue(result.startsWith(content));
		} catch (FileNotFoundException e) {
			fail(e.toString());
		} catch (IOException e) {
			fail(e.toString());
		} catch (ExtracterException e) {
			fail(e.toString());
		}
    }


}
