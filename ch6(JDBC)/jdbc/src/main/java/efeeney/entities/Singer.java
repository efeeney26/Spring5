package efeeney.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Singer implements Serializable {
	private Long id;
	private String firstname;
	private String lastname;
	private Date birthdate;
	private List<Album> albums;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public boolean addAlbum(Album album) {
		if(albums == null) {
			albums = new ArrayList<>();
			albums.add(album);
			return true;
		} else {
			if (albums.contains(album)) {
				return false;
			}
		}
		albums.add(album);
		return true;
	}

	public java.sql.Date getBirthdate() {
		return (java.sql.Date) birthdate;
	}

	public void setBirthdate(java.sql.Date birthdate) {
		this.birthdate = birthdate;
	}

	public List<Album> getAlbums() {
		return albums;
	}

	public void setAlbums(List<Album> albums) {
		this.albums = albums;
	}

	@Override
	public String toString() {
		return "Singer{" +
				"id=" + id +
				", firstname='" + firstname + '\'' +
				", lastname='" + lastname + '\'' +
				", birthdate=" + birthdate +
				'}';
	}
}
