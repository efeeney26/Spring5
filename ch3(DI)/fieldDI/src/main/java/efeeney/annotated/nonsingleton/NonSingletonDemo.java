package efeeney.annotated.nonsingleton;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.GenericApplicationContext;
import org.springframework.stereotype.Component;

@Configuration
@ComponentScan(basePackages = "efeeney.annotated.nonsingleton")
public class NonSingletonDemo {
	public static void main(String[] args) {
		GenericApplicationContext ctx = new AnnotationConfigApplicationContext(NonSingletonDemo.class);
		Fucker fucker1 = (Fucker) ctx.getBean("fucker");
		Fucker fucker2 = (Fucker) ctx.getBean("fucker");
		System.out.println(fucker1.equals(fucker2));
	}
}
