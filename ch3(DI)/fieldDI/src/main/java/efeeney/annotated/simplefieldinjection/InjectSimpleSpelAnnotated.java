package efeeney.annotated.simplefieldinjection;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.support.GenericXmlApplicationContext;
import org.springframework.stereotype.Service;

@Service("injectSimpleSpelAnno")
public class InjectSimpleSpelAnnotated {
	@Value("#{injectSimpleConfigAnno.name}")
	private String name;
	@Value("#{injectSimpleConfigAnno.age + 1}")
	private int age;
	@Value("#{injectSimpleConfigAnno.height}")
	private float height;
	@Value("#{injectSimpleConfigAnno.programmer}")
	private boolean programmer;
	@Value("#{injectSimpleConfigAnno.ageInSeconds}")
	private Long ageInSeconds;

	public String toString() {
		return "Name: " + name + "\n"
				+ "Age: " + age + "\n"
				+ "Age in Seconds: " + ageInSeconds + "\n"
				+ "Height: " + height + "\n"
				+ "Is Programmer?: " + programmer;
	}

	public static void main(String[] args) {
		GenericXmlApplicationContext ctx = new GenericXmlApplicationContext();
		ctx.load("classpath:spring/app-context-annotated.xml");
		ctx.refresh();
		InjectSimpleSpelAnnotated simpleSpelAnnotated = (InjectSimpleSpelAnnotated) ctx.getBean("injectSimpleSpelAnno");
		System.out.println(simpleSpelAnnotated);
		ctx.close();
	}
}
