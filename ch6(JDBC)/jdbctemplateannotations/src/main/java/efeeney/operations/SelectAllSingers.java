package efeeney.operations;

import efeeney.entity.Singer;
import org.springframework.jdbc.object.MappingSqlQuery;

import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;

public class SelectAllSingers extends MappingSqlQuery<Singer> {

	private static final String SQL_SELECT_ALL_SINGER = "select id, first_name, last_name, birth_date from singer";

	public SelectAllSingers(DataSource ds) {
		super(ds, SQL_SELECT_ALL_SINGER);
	}

	@Override
	protected Singer mapRow(ResultSet rs, int rowNum) throws SQLException {
		Singer singer = new Singer();
		singer.setId(rs.getLong("id"));
		singer.setFirstname(rs.getString("first_name"));
		singer.setLastname(rs.getString("last_name"));
		singer.setBirthdate(rs.getDate("birth_date"));
		return singer;
	}
}
