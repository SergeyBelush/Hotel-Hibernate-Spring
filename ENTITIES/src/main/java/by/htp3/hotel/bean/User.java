package by.htp3.hotel.bean;
import org.hibernate.annotations.*;
import org.hibernate.annotations.Cache;
import javax.persistence.*;
import java.util.Set;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "USER", schema = "mydb")
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
public class User {

	@Id
	@Column(name = "USER_ID")
	@GeneratedValue
	private Long userid;

	@Column(name = "NAME")
	private String name;

	@Column(name = "SURNAME")
	private String surname;

	@Column(name = "NUMBER_ROOM")
	private Long numberRoom;

	@Column(name = "LOGIN")
	private String login;

	@Column(name = "PASS")
	private String pass;

	@Column(name = "MAIL")
	private String mail;

	@OneToMany(mappedBy = "user")
	private Set<Room> rooms;

	public User() {
	}

	public String getLogin() {
		return login;
	}

	public String getPass() {
		return pass;
	}

	public String getMail() {
		return mail;
	}

	public Long getUserid() {
		return userid;
	}

	public void setUserid(Long userid) {
		this.userid = userid;
	}

	public Set<Room> getRooms() {
		return rooms;
	}

	public void setRooms(Set<Room> rooms) {
		this.rooms = rooms;
	}

	public Long getNumberRoom() {
		return numberRoom;
	}

	public void setNumberRoom(Long numberRoom) {
		this.numberRoom = numberRoom;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public void setPass(String pass) {
		this.pass = pass;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

}
