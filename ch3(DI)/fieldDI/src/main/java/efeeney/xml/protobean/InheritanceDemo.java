package efeeney.xml.protobean;

import org.springframework.context.support.GenericXmlApplicationContext;

public class InheritanceDemo {
	public static void main(String[] args) {
		GenericXmlApplicationContext ctx = new GenericXmlApplicationContext();
		ctx.load("classpath:spring/app-context-xml.xml");
		ctx.refresh();
		Whore parent = (Whore)ctx.getBean("parent");
		Whore child = (Whore)ctx.getBean("child");
		System.out.println("Parent: " + parent);
		System.out.println("Child: " + child);
	}
}
