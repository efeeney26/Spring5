package efeeney.dao;

import efeeney.entity.Singer;

import java.util.List;

public interface SingerDao {
	String findNameById(Long id);
	List<Singer> findAll();
	List<Singer> findAllWithAlbums();
}
