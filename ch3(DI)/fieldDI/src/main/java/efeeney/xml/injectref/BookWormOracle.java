package efeeney.xml.injectref;

public class BookWormOracle implements Oracle {
	private Encyclopedia encyclopedia;

	public void setEncyclopedia(Encyclopedia encyclopedia) {
		this.encyclopedia = encyclopedia;
	}

	@Override
	public String defineMeaningOfLife() {
		return "Encyclopedias are а waste of money - go "
				+ "see the world instead";
	}
}
