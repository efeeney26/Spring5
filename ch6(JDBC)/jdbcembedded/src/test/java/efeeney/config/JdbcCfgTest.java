package efeeney.config;

import efeeney.dao.SingerDao;
import org.junit.Test;
import org.springframework.context.support.GenericXmlApplicationContext;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

public class JdbcCfgTest {

	@Test
	public void testH2DB() {
		GenericXmlApplicationContext ctx = new GenericXmlApplicationContext();
		ctx.load("classpath:spring/embedded-h2-cfg.xml");
		ctx.refresh();
		testDao(ctx.getBean(SingerDao.class));
		ctx.close();
	}

	private void testDao(SingerDao singerDao){
		assertNotNull(singerDao);
		String singerName = singerDao.findNameById(1l);
		assertTrue("John Mayer".equals(singerName));
	}
}
