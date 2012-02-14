package com.lic.extracter.exception;

import org.springframework.web.client.RestClientException;

public class ExtracterException extends Exception {

	public ExtracterException(String string) {
		super(string);
	}

	public ExtracterException(Throwable e) {
		super(e);
	}
	

}
