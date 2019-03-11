package efeeney;

import efeeney.dao.PlainSingerDao;
import efeeney.dao.SingerDao;
import efeeney.entities.Singer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.Date;
import java.util.GregorianCalendar;
import java.util.List;

public class PlainJDBCDemo {
	private static SingerDao singerDao = new PlainSingerDao();
	private static final Logger logger = LoggerFactory.getLogger(PlainJDBCDemo.class);

	public static void main(String... args) {
		logger.info("Listing initial singer data:");

		listAllSingers();

		logger.info("-------------");
		logger.info("Insert a new singer");

		Singer singer = new Singer();
		singer.setFirstname("Ed");
		singer.setLastname("Sheeran");
		singer.setBirthdate(new Date((new GregorianCalendar(1991, 2, 19)).getTime().getTime()));
		singerDao.insert(singer);

		logger.info("Listing singer data after new singer created:");

		listAllSingers();

		/*logger.info("-------------");
		logger.info("Deleting the previous created singer");

		singerDao.delete(singer.getId());

		System.out.println("Listing singer data after new singer deleted:");

		Singer singer2 = new Singer();
		singer.setFirstname("Mim");
		singer.setLastname("Kaboom");
		singer.setBirthdate((java.sql.Date) new Date((new GregorianCalendar(1991, 2, 1991)).getTime().getTime()));
		singerDao.insert(singer);

		listAllSingers();*/
	}

	private static void listAllSingers() {
		List<Singer> singers = singerDao.findAll();

		for (Singer singer: singers) {
			logger.info(singer.toString());
		}
	}
}
