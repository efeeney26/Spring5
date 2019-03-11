package efeeney.annotated.beannamingtestanno;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.GenericApplicationContext;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Map;


public class AliasConfigDemo {
	@Configuration
	public static class AliasBeanConfig {
		@Bean(name = {"johnMayer","john","jonathan","johnny"})
		public Drawer drawer() {
			return new Drawer();
		}
	}

	public static void main(String[] args) {
		GenericApplicationContext ctx = new AnnotationConfigApplicationContext(AliasBeanConfig.class);
		Map<String, Drawer> beans = ctx.getBeansOfType(Drawer.class);
		beans.entrySet().stream()
				.forEach(bean -> System.out.println(bean.getKey() + " - aliases: " + Arrays.toString(ctx.getAliases(bean.getKey()))));
		ctx.close();
	}
}
