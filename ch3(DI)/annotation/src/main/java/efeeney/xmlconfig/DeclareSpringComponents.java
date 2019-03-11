package efeeney.xmlconfig;

import efeeney.decoupled.MessageRenderer;
import org.springframework.context.support.GenericXmlApplicationContext;

public class DeclareSpringComponents {
	public static void main(String[] args) {
		GenericXmlApplicationContext ctx = new GenericXmlApplicationContext();
		ctx.load("classpath:spring/app-context-xml-installmethod.xml");
		ctx.refresh();
		MessageRenderer mr = ctx.getBean("renderer", MessageRenderer.class);
		mr.render();
		ctx.close();
	}
}
