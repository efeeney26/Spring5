package efeeney.decoupled;

import org.springframework.stereotype.Component;

// простой компонент Spring Bean
@Component("provider")
public class HelloWorldMessageProvider implements MessageProvider {
	@Override
	public String getMessage() {
		return "Hello world!";
	}
}
