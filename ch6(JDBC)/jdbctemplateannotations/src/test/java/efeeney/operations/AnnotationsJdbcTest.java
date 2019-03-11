package efeeney.operations;

import efeeney.conf.AppConfig;
import efeeney.dao.SingerDao;
import efeeney.entity.Album;
import efeeney.entity.Singer;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.GenericApplicationContext;

import java.util.List;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

public class AnnotationsJdbcTest {
	private GenericApplicationContext ctx;
	private SingerDao singerDao;

	@Before
	public void setUp() {
		ctx = new AnnotationConfigApplicationContext(AppConfig.class);
		singerDao = ctx.getBean(SingerDao.class);
		assertNotNull(singerDao);
	}

	@Test
	public void testFindAll() {
		List<Singer> singers = singerDao.findAll();
		assertTrue(singers.size() == 3);
		singers.forEach(singer -> {
			System.out.println(singer);
			if (singer.getAlbums() != null)
				for (Album album : singer.getAlbums()) {
					System.out.println("\t--> " + album);
				}
		});
		ctx.close();
	}

	@After
	public void tearDown() {
		ctx.close();
	}
}
