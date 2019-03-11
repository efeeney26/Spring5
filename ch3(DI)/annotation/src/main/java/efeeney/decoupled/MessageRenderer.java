package efeeney.decoupled;

public interface MessageRenderer {
	void render();
	void setMessageProvider(MessageProvider messageProvider);
	MessageProvider getMessageProvider();
}
