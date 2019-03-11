package efeeney.dao;

import efeeney.MySQLErrorCodesTranslator;
import efeeney.entity.Singer;
import org.springframework.beans.factory.BeanCreationException;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;
import java.util.List;

public class JdbcSingerDao implements SingerDao, InitializingBean {

	private DataSource dataSource;
	private JdbcTemplate jdbcTemplate;

	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
		JdbcTemplate jdbcTemplate = new JdbcTemplate();
		MySQLErrorCodesTranslator errorCodesTranslator = new MySQLErrorCodesTranslator();
		errorCodesTranslator.setDataSource(dataSource);
		jdbcTemplate.setExceptionTranslator(errorCodesTranslator);
		this.jdbcTemplate = jdbcTemplate;
	}

	@Override
	public String findNameById(Long id) {
		return jdbcTemplate.queryForObject("select first_name || ' ' || last_name from singer where id = ?", new Object[]{id}, String.class);
	}

	@Override
	public List<Singer> findAll() {
		return null;
	}

	@Override
	public List<Singer> findAllWithAlbums() {
		return null;
	}

	@Override
	public void afterPropertiesSet() throws Exception {
		if(dataSource == null) {
			throw new BeanCreationException("Must set dataSource on SingerDao");
		}
	}
}
