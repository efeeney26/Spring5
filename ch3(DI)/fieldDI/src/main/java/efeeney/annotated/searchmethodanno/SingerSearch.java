package efeeney.annotated.searchmethodanno;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component("singersearch")
@Scope("prototype")
public class SingerSearch {
	private String lyric = "I played а quick game of chess with the salt and pepper shaker";

	public void sing() {
		//System.out.println(lyric);
	}
}
