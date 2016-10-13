package by.htp3.hotel.bean;

import org.hibernate.annotations.*;
import org.hibernate.annotations.Cache;
import javax.persistence.*;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Objects;

@Entity
@Table(name = "ROOM", schema = "mydb")
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
public class Room {

	@Id
	@Column(name = "ROOM_ID")
	@GeneratedValue
	private Long id;

	@Column(name = "NUMBER")
	private Long number;

	@Column(name = "TYPE")
	private String type;

	@Column(name = "PRICE")
	private int price;

	public Room(Long number, String type, int price, Integer userid){
		this.number = number;
		this.type = type;
		this.price = price;
	}

	public Room() {
	}


	public Long getId() {
		return id;
	}

	public void setId(Long roomid) {
		this.id = roomid;
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

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		Room room = (Room) o;
		return price == room.price &&
				Objects.equals(id, room.id) &&
				Objects.equals(number, room.number) &&
				Objects.equals(type, room.type);
	}

	@Override
	public String toString() {
		return "Room{" +
				"roomid=" + id +
				", number=" + number +
				", type='" + type + '\'' +
				", price=" + price +
				'}';
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, number, type, price);
	}
}
