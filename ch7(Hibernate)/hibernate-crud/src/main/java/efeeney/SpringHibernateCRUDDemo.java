package efeeney;

import efeeney.config.AdvanceConfig;
import efeeney.dao.SingerDao;
import efeeney.entities.Singer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.GenericApplicationContext;

public class SpringHibernateCRUDDemo {
	private static Logger logger = LoggerFactory.getLogger(SpringHibernateCRUDDemo.class);

	public static void main(String[] args) {
		GenericApplicationContext ctx = new AnnotationConfigApplicationContext(AdvanceConfig.class);
		SingerDao singerDao = ctx.getBean(SingerDao.class);
		Singer singer = singerDao.findById(4l);
		logger.info(singer.toString());

		ctx.close();
	}
}
