package efeeney.xml.searchmethod;

import efeeney.decoupled.DemoBeanXml;

public abstract class AbstractLookupDemoBean implements DemoBeanXml {
	public abstract SingerXML getMySinger();

	@Override
	public void doSomething() {
		getMySinger().sing();
	}
}
