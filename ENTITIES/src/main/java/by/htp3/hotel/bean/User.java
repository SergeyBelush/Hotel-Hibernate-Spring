package by.htp3.hotel.bean;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "USER", schema = "mydb")
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
public class User {

	@Id
	@Column(name = "USER_ID")
	@GeneratedValue
	private Long id;

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

	@Column(name = "ROLE")
	private Integer role;

	@OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
	private Set<Order> orders = new HashSet<>();

	public User() {
	}

	public boolean isAdmin() {
		return role == 1;
	}

	public Integer getRole() {
		return role;
	}

	public void setRole(Integer role) {
		this.role = role;
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

	public Long getId() {
		return id;
	}

	public void setId(Long userid) {
		this.id = userid;
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

	public Set<Order> getOrders() {
		return orders;
	}

	public void setOrders(Set<Order> reservations) {
		this.orders = reservations;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		User user = (User) o;
		return Objects.equals(id, user.id) &&
				Objects.equals(name, user.name) &&
				Objects.equals(surname, user.surname) &&
				Objects.equals(numberRoom, user.numberRoom) &&
				Objects.equals(login, user.login) &&
				Objects.equals(pass, user.pass) &&
				Objects.equals(mail, user.mail);
	}

	@Override
	public int hashCode() {

		return Objects.hash(id, name, surname, numberRoom, login, pass, mail);
	}

	@Override
	public String toString() {
		return "User{" +
				"userid=" + id +
				", name='" + name + '\'' +
				", surname='" + surname + '\'' +
				", numberRoom=" + numberRoom +
				", login='" + login + '\'' +
				", pass='" + pass + '\'' +
				", mail='" + mail + '\'' +
				'}';
	}
}
