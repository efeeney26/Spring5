package com.efeeney.decoupled;

public class HelloWorldMessageProvider implements MessageProvider{

	@Override
	public String getMessage() {
		return "Hello world!";
	}
}
