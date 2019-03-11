package efeeney.annotated;

import efeeney.decoupled.MessageProvider;
import efeeney.decoupled.MessageRenderer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("rendererAnno")
public class StandardOutMessageRendererAnno implements MessageRenderer {

	MessageProvider messageProvider;

	@Override
	public void render() {
		if (messageProvider == null) {
			throw new RuntimeException("You must set the "
					+ "property messageProvider of class:"
					+ StandardOutMessageRendererAnno.class.getName());
		}
		System.out.println(messageProvider.getMessage());
	}

	@Override
	@Autowired
	public void setMessageProvider(MessageProvider messageProvider) {
		this.messageProvider = messageProvider;
	}

	@Override
	public MessageProvider getMessageProvider() {
		return messageProvider;
	}
}
