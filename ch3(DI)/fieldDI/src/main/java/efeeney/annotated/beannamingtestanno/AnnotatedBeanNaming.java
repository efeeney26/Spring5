package efeeney.annotated.beannamingtestanno;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.GenericApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

import java.util.Map;

@Configuration
@ComponentScan(basePackages = {"efeeney.annotated.beannamingtestanno"})
public class AnnotatedBeanNaming {
	public static void main(String[] args) {
		GenericApplicationContext ctx = new AnnotationConfigApplicationContext(AnnotatedBeanNaming.class);
		Map<String, Drawer> beans = ctx.getBeansOfType(Drawer.class);
		beans.entrySet().stream()
				.forEach(bean -> System.out.println(bean.getKey()));
		ctx.close();

	}
}
