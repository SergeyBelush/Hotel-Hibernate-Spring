package by.htp3.hotel.bean;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;
import javax.persistence.*;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "user", schema = "mydb")
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


	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		User user = (User) o;
		return Objects.equals(userid, user.userid) &&
				Objects.equals(name, user.name) &&
				Objects.equals(surname, user.surname) &&
				Objects.equals(numberRoom, user.numberRoom) &&
				Objects.equals(login, user.login) &&
				Objects.equals(pass, user.pass) &&
				Objects.equals(mail, user.mail) &&
				Objects.equals(rooms, user.rooms);
	}

	@Override
	public int hashCode() {
		return Objects.hash(userid, name, surname, numberRoom, login, pass, mail, rooms);
	}

	@Override
	public String toString() {
		return "User{" +
				"userid=" + userid +
				", name='" + name + '\'' +
				", surname='" + surname + '\'' +
				", numberRoom=" + numberRoom +
				", login='" + login + '\'' +
				", pass='" + pass + '\'' +
				", mail='" + mail + '\'' +
				", rooms=" + rooms +
				'}';
	}
}
