package efeeney.config;

import efeeney.dao.SingerDao;
import efeeney.entity.Album;
import efeeney.entity.Singer;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.GenericApplicationContext;

import java.util.List;

import static junit.framework.TestCase.assertTrue;
import static org.junit.Assert.assertNotNull;

public class RowMapperTest {
	@Test
	public void testRowMeapper() {
		GenericApplicationContext ctx = new AnnotationConfigApplicationContext(NamedJdbcCfg.class);
		SingerDao singerDao = ctx.getBean(SingerDao.class);
		assertNotNull(singerDao);
		List<Singer> singers = singerDao.findAll();
		assertTrue(singers.size() == 3);

		singers.forEach(singer -> {
			System.out.println(singer);
			if (singer.getAlbums() != null) {
				for (Album album : singer.getAlbums()) {
					System.out.println("---" + album);
				}
			}
		});

		ctx.close();
	}
}
