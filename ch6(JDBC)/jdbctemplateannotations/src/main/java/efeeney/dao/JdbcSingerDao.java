package efeeney.dao;

import efeeney.entity.Singer;
import efeeney.operations.SelectAllSingers;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import javax.sql.DataSource;
import java.util.List;

@Repository("singerDao")
public class JdbcSingerDao implements SingerDao {

	private static final Log logger = LogFactory.getLog(JdbcSingerDao.class);

	private DataSource dataSource;
	private SelectAllSingers selectAllSingers;

	public DataSource getDataSource() {
		return dataSource;
	}

	@Resource(name = "dataSource")
	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
	}

	@Override
	public List<Singer> findAll() {
		return selectAllSingers.execute();
	}

	@Override
	public List<Singer> findByFirstName(String firstName) {
		return null;
	}

	@Override
	public String findNameById(Long id) {
		return null;
	}

	@Override
	public String findLastNameByid(Long id) {
		return null;
	}

	@Override
	public String findFirstNameByid(Long id) {
		return null;
	}

	@Override
	public void insert(Singer singer) {

	}

	@Override
	public void update(Singer singer) {

	}

	@Override
	public void delete(Long singerId) {

	}

	@Override
	public void insertWithAlbums(Singer singer) {

	}
}
