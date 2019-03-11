package efeeney.annotated;

import efeeney.decoupled.HelloWorldMessageProvider;
import efeeney.decoupled.MessageProvider;
import efeeney.decoupled.MessageRenderer;
import efeeney.decoupled.StandardOutMessageRenderer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

//равнозначной элементу разметки <context: component-scanning .. />
@ComponentScan(basePackages = {"efeeney"})
@Configuration
public class HelloWorldConfiguration {
	@Bean
	public MessageProvider providerAnno() {
		return new ConfigurableMessageProviderAnnoteted("Fuck you");
	}
	@Bean
	public MessageRenderer rendererAnno() {
		MessageRenderer renderer = new StandardOutMessageRendererAnno();
		renderer.setMessageProvider(providerAnno());
		return renderer;
	}
}
