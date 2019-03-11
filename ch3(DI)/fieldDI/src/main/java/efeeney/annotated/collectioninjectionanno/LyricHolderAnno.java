package efeeney.annotated.collectioninjectionanno;

import efeeney.decoupled.ContentHolder;
import org.springframework.stereotype.Service;

@Service("lyricHolderAnno")
public class LyricHolderAnno implements ContentHolder {
	private String value = "Kanye West is do the best";

	@Override
	public String toString() {
		return "LyricHolderAnno{" +
				"value='" + value + '\'' +
				'}';
	}
}
