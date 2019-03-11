package efeeney.annotated.searchmethodanno;

import efeeney.decoupled.DemoBeanAnno;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.GenericApplicationContext;
import org.springframework.util.StopWatch;


public class LookupConfigDemo {
	@Configuration
	@ComponentScan(basePackages = {"efeeney.annotated.searchmethodanno"})
	public static class LookupConfig {}
	public static void main(String[] args) {
		GenericApplicationContext ctx = new AnnotationConfigApplicationContext(LookupConfig.class);
		DemoBeanAnno abstractBean = ctx.getBean("abstractLookupBeanAnno", DemoBeanAnno.class);
		DemoBeanAnno standartBean = ctx.getBean("standardLookupBeanAnno", DemoBeanAnno.class);
		displayInfo("abstractLookupBeanAnno", abstractBean);
		displayInfo("standardLookupBeanAnno", standartBean);
		ctx.close();
	}

	public static void displayInfo(String beanName, DemoBeanAnno bean) {
		SingerSearch singer1 = bean.getMySingerAnno();
		SingerSearch singer2 = bean.getMySingerAnno();

		System.out.println(beanName + ": " + "SingerSearch Instances the Same?: " + (singer1 == singer2));
		StopWatch stopWatch = new StopWatch();
		stopWatch.start("lookupDemo");
		for (int i = 0; i < 100000; i++) {
			SingerSearch singer = bean.getMySingerAnno();
			singer.sing();
		}
		stopWatch.stop();
		System.out.println("100000 gets took " + stopWatch.getTotalTimeMillis() + "ms");
	}
}
