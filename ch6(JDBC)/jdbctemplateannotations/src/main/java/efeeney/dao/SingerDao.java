package efeeney.dao;

import efeeney.entity.Singer;

import java.util.List;

public interface SingerDao {
	List<Singer> findAll();
	List<Singer> findByFirstName(String firstName);
	String findNameById(Long id);
	String findLastNameByid(Long id);
	String findFirstNameByid(Long id);
	void insert(Singer singer);
	void update(Singer singer);
	void delete(Long singerId);
	void insertWithAlbums(Singer singer);
}
