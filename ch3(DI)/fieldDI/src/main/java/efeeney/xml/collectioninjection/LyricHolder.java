package efeeney.xml.collectioninjection;

import efeeney.decoupled.ContentHolder;

public class LyricHolder implements ContentHolder {
	private String value = "Lil Kin is a whore";

	@Override
	public String toString() {
		return "LyricHolder{" +
				"value='" + value + '\'' +
				'}';
	}
}
