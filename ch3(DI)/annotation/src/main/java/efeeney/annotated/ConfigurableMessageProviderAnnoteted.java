package efeeney.annotated;

import efeeney.decoupled.MessageProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Service("providerAnno")
public class ConfigurableMessageProviderAnnoteted implements MessageProvider {

	private String message;

	@Autowired
	public ConfigurableMessageProviderAnnoteted(@Value("Configurable message") String message) {
		this.message = message;
	}

	@Override
	public String getMessage() {
		return null;
	}
}
