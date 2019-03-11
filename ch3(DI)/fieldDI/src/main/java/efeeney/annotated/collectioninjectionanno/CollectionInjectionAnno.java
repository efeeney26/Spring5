package efeeney.annotated.collectioninjectionanno;

import efeeney.xml.collectioninjection.CollectionInjection;
import org.springframework.context.support.GenericXmlApplicationContext;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

@Service("injectCollectionAnno")
public class CollectionInjectionAnno {
	@Resource(name = "map")
	private Map<String, Object> map;
	@Resource(name = "props")
	private Properties props;
	@Resource(name = "set")
	private Set set;
	@Resource(name = "list")
	private List list;

	public static void main(String[] args) {
		GenericXmlApplicationContext ctx = new GenericXmlApplicationContext();
		ctx.load("classpath:spring/app-context-annotated.xml");
		ctx.refresh();
		CollectionInjectionAnno instance = (CollectionInjectionAnno) ctx.getBean("injectCollectionAnno");
		instance.displayInfo();
		ctx.close();
	}

	public void displayInfo() {
		System.out.println("Map contents:\n");
		map.entrySet().stream()
				.forEach(e -> System.out.println("Key: " + e.getKey() + " - Value: " + e.getValue()));
		System.out.println("\nProperties contents:\n");
		props.entrySet().stream()
				.forEach(e -> System.out.println("Key: " + e.getKey() + " - Value: " + e.getValue()));
		System.out.println("\nSet contents:\n");
		set.forEach(obj ->
				System.out.println("Value: " + obj));
		System.out.println("\nList contents:\n");
		list.forEach(obj ->
				System.out.println("Value: " + obj));
	}
}
