package efeeney.xml.searchmethod;

import efeeney.decoupled.DemoBeanXml;
import org.springframework.context.support.GenericXmlApplicationContext;
import org.springframework.util.StopWatch;

public class LookupDemo {
	public static void main(String[] args) {
		GenericXmlApplicationContext ctx = new GenericXmlApplicationContext();
		ctx.load("classpath:spring/app-context-xml.xml");
		ctx.refresh();
		DemoBeanXml abstractBean = ctx.getBean("abstractLookupBean", DemoBeanXml.class);
		DemoBeanXml standartBean = ctx.getBean("standartLookupBean", StandartLookupDemoBean.class);
		displayInfo("abstractLookupBean", abstractBean);
		displayInfo("standartLookupBean", standartBean);
		ctx.close();
	}

	public static void displayInfo(String beanName, DemoBeanXml bean) {
		SingerXML singer1 = bean.getMySinger();
		SingerXML singer2 = bean.getMySinger();
		System.out.println(beanName + ": " + "SingerSearch Instances the Same?: " + (singer1 == singer2));
		StopWatch stopWatch = new StopWatch();
		stopWatch.start("lookupDemo");
		for (int i = 0; i < 100000; i++) {
			SingerXML singer = bean.getMySinger();
			singer.sing();
		}
		stopWatch.stop();
		System.out.println("100000 gets took " + stopWatch.getTotalTimeMillis() + "ms");
	}
}
