package efeeney.dao;

import efeeney.entities.Singer;

import java.util.List;

public interface SingerDao {
	List<Singer> findAll();
	List<Singer> findByFirstName(String firstName);
	String findLastNameByid(Long id);
	String findFirstNameByid(Long id);
	void insert(Singer singer);
	void update(Singer singer);
	void delete(Long singerId);
	List<Singer> findAllWithDetail();
	void insertWithDetail(Singer singer);
}
