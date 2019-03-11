package efeeney.xml.beannamingtest;

import org.springframework.context.support.GenericXmlApplicationContext;

import java.util.Map;

public class BeanNamingTest {
	public static void main(String[] args) {
		GenericXmlApplicationContext ctx = new GenericXmlApplicationContext();
		ctx.load("classpath:spring/app-context-01.xml");
		ctx.refresh();
		Map<String, String> beans = ctx.getBeansOfType(String.class);
		beans.entrySet().stream()
				.forEach(bean -> System.out.println(bean.getKey()));
		ctx.getAliases("jim");
		ctx.close();
	}
}
