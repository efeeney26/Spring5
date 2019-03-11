package efeeney.annotated.searchmethodanno;

import efeeney.decoupled.DemoBeanAnno;
import org.springframework.beans.factory.annotation.Lookup;
import org.springframework.stereotype.Component;

@Component("abstractLookupBeanAnno")
public class AbstractLookupDemoBean implements DemoBeanAnno {
	@Override
	@Lookup("singersearch")
	public SingerSearch getMySingerAnno() {
		return null;//переопределяется автоматически
	}

	@Override
	public void doSomething() {
		getMySingerAnno().sing();
	}
}
