package com.efeeney.annotated;

import com.efeeney.decoupled.HelloWorldMessageProvider;
import com.efeeney.decoupled.MessageProvider;
import com.efeeney.decoupled.MessageRenderer;
import com.efeeney.decoupled.StandardOutMessageRenderer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class HelloWorldConfiguration {

	//равнозначно разметке <bean id="provider" class=" .. "/>
	@Bean
	public MessageProvider provider() {
		return new HelloWorldMessageProvider();
	}

	//равнозначно разметке <bean id="renderer" class=" .. "/>
	@Bean
	public MessageRenderer renderer() {
		MessageRenderer renderer = new StandardOutMessageRenderer();
		renderer.setMessageProvider(provider());
		return renderer;
	}



}
