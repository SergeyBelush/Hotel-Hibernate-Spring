package by.htp3.hotel.bean;

import org.hibernate.annotations.*;
import org.hibernate.annotations.Cache;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.*;
import java.util.Date;
import java.util.Objects;
import javax.persistence.Id;

@Entity
@Table(name = "BOOKING", schema = "mydb")
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
public class Order {

    @Id
    @GeneratedValue
    @Column(name = "ID")
    private Long id;

    @Column(name = "DATE_IN")
    private Date dateIn;

    @Column(name = "DATE_OUT")
    private Date dateOut;

    @ManyToOne
    @JoinColumn(name = "USER_ID")
    private User user;

    @ManyToOne
    @JoinColumn(name = "ROOM_ID")
    private Room room;

    public Order(){
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Room getRoom() {
        return room;
    }

    public void setRoom(Room room) {
        this.room = room;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Order order = (Order) o;
        return Objects.equals(id, order.id) &&
                Objects.equals(dateIn, order.dateIn) &&
                Objects.equals(dateOut, order.dateOut);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, dateIn, dateOut);
    }

    @Override
    public String toString() {
        return "Order{" +
                "reservarionId=" + id +
                ", dateIn=" + dateIn +
                ", dateOut=" + dateOut +
                '}';
    }

    public Date getDateIn() {
        return dateIn;
    }

    public void setDateIn(Date dateIn) {
        this.dateIn = dateIn;
    }

    public Date getDateOut() {
        return dateOut;
    }

    public void setDateOut(Date dateOut) {
        this.dateOut = dateOut;
    }

}
