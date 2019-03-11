package efeeney.dao;

import efeeney.entity.Album;
import efeeney.entity.Singer;
import org.springframework.beans.factory.BeanCreationException;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class JdbcSingerDaoNamed implements SingerDao, InitializingBean {

	private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

	@Override
	public String findNameById(Long id) {
		String sql = "select first_name || ' ' || last_name from singer where id = :singerId";
		Map<String, Object> namedParameters = new HashMap<>();
		namedParameters.put("singerId", id);
		return namedParameterJdbcTemplate.queryForObject(sql, namedParameters, String.class);
	}

	@Override
	public List<Singer> findAll() {
		String sql = "select id, first_name, last_name, birth_date from singer";
		return namedParameterJdbcTemplate.query(sql, new SingerMapper());
	}

	@Override
	public List<Singer> findAllWithAlbums() {
		String sql = "select s.id, s.first_name, s.last_name, s.birth_date, a.id as album_id, a.title, a.release_date from singer s left join album a on s.id = a.singer_id";
		return namedParameterJdbcTemplate.query(sql, new SingerWithDetailExtractor());
	}

	private static final class SingerWithDetailExtractor implements ResultSetExtractor<ArrayList<Singer>> {

		@Override
		public ArrayList<Singer> extractData(ResultSet rs) throws SQLException, DataAccessException {
			Map<Long, Singer> map = new HashMap<>();
			Singer singer;
			while (rs.next()) {
				Long id = rs.getLong("id");
				singer = map.get(id);
				if (singer == null) {
					singer = new Singer();
					singer.setId(id);
					singer.setFirstname(rs.getString("first_name"));
					singer.setLastname(rs.getString("last_name"));
					singer.setBirthdate(rs.getDate("birth_date"));
					singer.setAlbums(new ArrayList<>());
					map.put(id, singer);
				}
				Long albumId = rs.getLong("album_id");
				if(albumId > 0) {
					Album album = new Album();
					album.setId(albumId);
					album.setSingerId(id);
					album.setTitle(rs.getString("title"));
					album.setReleaseDate(rs.getDate("release_date"));
					singer.addAlbum(album);
				}
			}
			return new ArrayList<>(map.values());
		}
	}

	private static final class SingerMapper implements RowMapper<Singer> {

		@Override
		public Singer mapRow(ResultSet rs, int rowNum) throws SQLException {
			Singer singer = new Singer();
			singer.setId(rs.getLong("id"));
			singer.setFirstname(rs.getString("first_name"));
			singer.setLastname(rs.getString("last_name"));
			singer.setBirthdate(rs.getDate("birth_date"));
			return singer;
		}
	}

	public void setNamedParameterJdbcTemplate(NamedParameterJdbcTemplate namedParameterJdbcTemplate) {
		this.namedParameterJdbcTemplate = namedParameterJdbcTemplate;
	}


	@Override
	public void afterPropertiesSet() throws Exception {
		if (namedParameterJdbcTemplate == null)
			throw new BeanCreationException("Null NamedParameterJdbcTemplate оr SingerDao");
	}
}
