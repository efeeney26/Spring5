package efeeney.decoupled;

import efeeney.xml.searchmethod.SingerXML;

//интерфейс DemoBeanXml, который реализуется в классах обоих одиночных компонентов Spring Beans
public interface DemoBeanXml {
	SingerXML getMySinger();
	void doSomething();
}
