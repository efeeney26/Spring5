package efeeney.annotated.searchmethodanno;

import efeeney.decoupled.DemoBeanAnno;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component("standardLookupBeanAnno")
public class StandartLookupDemoBean implements DemoBeanAnno {

	private SingerSearch singer;

	@Autowired
	@Qualifier("singersearch")
	public void setSinger(SingerSearch singer) {
		this.singer = singer;
	}

	public SingerSearch getMySingerAnno() {
		return singer;
	}

	@Override
	public void doSomething() {
		singer.sing();
	}
}
