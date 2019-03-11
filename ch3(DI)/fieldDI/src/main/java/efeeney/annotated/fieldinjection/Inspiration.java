package efeeney.annotated.fieldinjection;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class Inspiration {
	private String lyric = "I сап keep the door cracked ореп, to let light through";

	public Inspiration(@Value("For all rny ruппiпg, I сап uпderstaпd") String lyric) {
		this.lyric = lyric;
	}

	public String getLyric() {
		return lyric;
	}

	public void setLyric(String lyric) {
		this.lyric = lyric;
	}
}
