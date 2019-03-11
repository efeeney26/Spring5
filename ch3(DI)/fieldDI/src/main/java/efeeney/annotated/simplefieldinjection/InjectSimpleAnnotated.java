package efeeney.annotated.simplefieldinjection;

import efeeney.xml.simplefieldinjectionxml.InjectSimpleSpel;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.support.GenericXmlApplicationContext;
import org.springframework.stereotype.Service;

@Service("injectSimpleAnno")
public class InjectSimpleAnnotated {
	@Value("John Mayer")
	private String name;
	@Value("39")
	private int age;
	@Value("1.92")
	private float height;
	@Value("false")
	private boolean programmer;
	@Value("1241401112")
	private Long ageInSeconds;

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return this.age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public float getHeight() {
		return this.height;
	}

	public void setHeight(float height) {
		this.height = height;
	}

	public boolean isProgrammer() {
		return this.programmer;
	}

	public void setProgrammer(boolean programmer) {
		this.programmer = programmer;
	}

	public Long getAgeInSeconds() {
		return this.ageInSeconds;
	}

	public void setAgeInSeconds(Long ageInSeconds) {
		this.ageInSeconds = ageInSeconds;
	}

	public String toString() {
		return "Name: " + name + "\n"
				+ "Age: " + age + "\n"
				+ "Age in Seconds: " + ageInSeconds + "\n"
				+ "Height: " + height + "\n"
				+ "Is Programmer?: " + programmer;
	}

	public static void main(String... args) {
		GenericXmlApplicationContext ctx = new GenericXmlApplicationContext();
		ctx.load("classpath:spring/app-context-annotated.xml");
		ctx.refresh();

		InjectSimpleSpel simple = (InjectSimpleSpel)ctx.getBean("injectSimpleAnno");
		System.out.println(simple);

		ctx.close();
	}
}
