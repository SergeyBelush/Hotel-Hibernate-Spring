package by.htp3.hotel.bean;

import org.hibernate.annotations.*;
import org.hibernate.annotations.Cache;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.*;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.Id;

@Entity
@Table(name = "BOOKING", schema = "mydb")
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
public class Order {

    @Id
    @GeneratedValue
    private Long id;

    @Column(name = "DATE")
    private Date date;

    @ManyToMany(mappedBy = "orders")
    private Set<Room> rooms = new HashSet<>();

    public Order(){
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Set<Room> getRooms() {
        return rooms;
    }

    public void setRooms(Set<Room> rooms) {
        this.rooms = rooms;
    }
}
