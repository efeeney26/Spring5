package efeeney.annotated.nonsingleton;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("prototype")
public class Fucker {
	private String fuckname = "unknown";

	public Fucker(@Value("Serj")String fuckname) {
		this.fuckname = fuckname;
	}
}
