package efeeney.dao;

import efeeney.entities.Singer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PlainSingerDao implements SingerDao {

	private static Logger logger = LoggerFactory.getLogger(PlainSingerDao.class);

	static {
		try {
			Class.forName("org.postgresql.Driver");
		}catch (ClassNotFoundException ex) {
			logger.error("Problem loading DB dDiver!");
		}
	}

	private Connection getConnection() throws SQLException {
		return DriverManager.getConnection(
				"jdbc:postgresql://localhost/springjdbctest?useSSL=true",
				"postgres", "koch2912");
	}

	private void closeConnection (Connection connection) {
		if (connection == null) {
			return;
		}
		try {
			connection.close();
		}catch (SQLException ex) {
			logger.error("Problem closing connection to the database!");
		}
	}

	@Override
	public List<Singer> findAll() {
		List<Singer> result = new ArrayList<>();
		Connection connection = null;
		try {
			connection = getConnection();
			PreparedStatement statement =
					connection.prepareStatement("select * from singer");
			ResultSet resultSet = statement.executeQuery();
			while (resultSet.next()) {
				Singer singer = new Singer();
				singer.setId(resultSet.getLong("id"));
				singer.setFirstname(resultSet.getString("first_name"));
				singer.setLastname(resultSet.getString("last_name"));
				singer.setBirthdate(resultSet.getDate("birth_date"));
				result.add(singer);
			}
			statement.close();
		} catch (SQLException ex) {
			logger.error("Problem when executing SELECT!");
		} finally {
			closeConnection(connection);
		}
		return result;
	}

	@Override
	public List<Singer> findByFirstName(String firstName) {
		throw new NotImplementedException();
	}

	@Override
	public String findLastNameByid(Long id) {
		throw new NotImplementedException();
	}

	@Override
	public String findFirstNameByid(Long id) {
		throw new NotImplementedException();
	}

	@Override
	public void insert(Singer singer) {
		Connection connection = null;
		try {
			connection = getConnection();
			PreparedStatement statement = connection.prepareStatement(
					"insert into Singer (first_name, last_name, birth_date) values (?, ?, ?)"
					, Statement.RETURN_GENERATED_KEYS);
			statement.setString(1, singer.getFirstname());
			statement.setString(2, singer.getLastname());
			statement.setDate(3, singer.getBirthdate());
			statement.execute();
			ResultSet generatedKeys = statement.getGeneratedKeys();
			if (generatedKeys.next()) {
				singer.setId(generatedKeys.getLong(1));
			}
		} catch (SQLException ex) {
			logger.error(ex.getSQLState());
			logger.error("Problem executing INSERT");
		} finally {
			closeConnection(connection);
		}
	}

	@Override
	public void update(Singer singer) {
		throw new NotImplementedException();
	}

	@Override
	public void delete(Long singerId) {
		Connection connection = null;
		try {
			connection = getConnection();
			PreparedStatement statement = connection.prepareStatement("delete from singer where id=?");
			statement.setLong(1, singerId);
			statement.execute();
		} catch (SQLException ex) {
			logger.error("Problem executing DELETE");
		} finally {
			closeConnection(connection);
		}
	}

	@Override
	public List<Singer> findAllWithDetail() {
		throw new NotImplementedException();
	}

	@Override
	public void insertWithDetail(Singer singer) {
		throw new NotImplementedException();
	}
}
