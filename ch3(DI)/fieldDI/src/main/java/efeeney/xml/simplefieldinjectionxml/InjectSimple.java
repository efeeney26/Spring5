package efeeney.xml.simplefieldinjectionxml;

import org.springframework.context.support.GenericXmlApplicationContext;


public class InjectSimple {
	private String name;
	private int age;
	private float height;
	private boolean programmer;
	private long ageInSeconds;

	public static void main(String[] args) {
		GenericXmlApplicationContext ctx = new GenericXmlApplicationContext();
		ctx.load("classpath:spring/app-context-xml.xml");
		ctx.refresh();
		InjectSimple simple = (InjectSimple) ctx.getBean("injectSimple");
		System.out.println(simple);
		ctx.close();
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public void setHeight(float height) {
		this.height = height;
	}

	public void setProgrammer(boolean programmer) {
		this.programmer = programmer;
	}

	public void setAgeInSecond(long ageInSecond) {
		this.ageInSeconds = ageInSecond;
	}

	@Override
	public String toString() {
		return "InjectSimple{" +
				"name='" + name + '\'' +
				", age=" + age +
				", height=" + height +
				",Is programmer?:" + programmer +
				", ageInSecond=" + ageInSeconds +
				'}';
	}
}
