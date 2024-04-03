package com.tnfb.exceptions;

@SuppressWarnings("serial")
public class PrpertyFileUsageException extends FrameworkException{

	public PrpertyFileUsageException(String message) {
		super(message);
	}
	
	public PrpertyFileUsageException(String message,Throwable cause) {
		super(message,cause);
	}

}
