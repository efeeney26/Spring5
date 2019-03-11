package efeeney.xml.searchmethod;

import efeeney.decoupled.DemoBeanXml;

public class StandartLookupDemoBean implements DemoBeanXml {

	private SingerXML mySinger;

	public void setMySinger(SingerXML mySinger) {
		this.mySinger = mySinger;
	}

	@Override
	public SingerXML getMySinger() {
		return mySinger;
	}

	@Override
	public void doSomething() {
		mySinger.sing();
	}
}
