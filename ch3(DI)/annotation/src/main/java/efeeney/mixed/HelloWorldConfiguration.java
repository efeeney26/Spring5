package efeeney.mixed;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;

//в конфигурационном классе можно импортировать определения компонентов Spring Beans из одного или нескольких ХМL-файлов
// конфигурации, используя аннотацию @ImportResource
//И тогда начальную загрузку можно выполнить с помощью одного и того же класса
@ImportResource(locations = "classpath:spring/app-context-xml.xml")

@Configuration
public class HelloWorldConfiguration {
}
