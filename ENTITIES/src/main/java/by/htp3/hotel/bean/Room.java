package by.htp3.hotel.bean;

import org.hibernate.annotations.*;
import org.hibernate.annotations.Cache;
import javax.persistence.*;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "ROOM", schema = "mydb")
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
public class Room {

	@Id
	@Column(name = "ROOM_ID")
	@GeneratedValue
	private Long roomid;

	@Column(name = "NUMBER")
	private Long number;

	@Column(name = "TYPE")
	private String type;

	@Column(name = "PRICE")
	private int price;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "user_id")
	private User user;

	@ManyToMany(cascade = {CascadeType.ALL})
	@JoinTable(name="ROOM_BOOKING",
			joinColumns={@JoinColumn(name="ROOM_ID")},
			inverseJoinColumns={@JoinColumn(name="BOOKING_ID")})
	private Set<Order> orders = new HashSet<>();
	private Long userid;

	public Room(Long number, String type, int price, Integer userid){
		this.number = number;
		this.type = type;
		this.price = price;
	}

	public Room() {
	}

	public void setUserid(Long userid) {
		this.userid = userid;
	}

	public Long getRoomid() {
		return roomid;
	}

	public void setRoomid(Long roomid) {
		this.roomid = roomid;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Set<Order> getOrders() {
		return orders;
	}

	public void setOrders(Set<Order> orders) {
		this.orders = orders;
	}

	public Long getNumber() {
		return number;
	}
	
	public void setNumber(Long number) {
		this.number = number;
	}
	
	public String getType() {
		return type;
	}
	
	public void setType(String type) {
		this.type = type;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public Long getUserid() {
		return userid;
	}
}
