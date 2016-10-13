package by.htp3.hotel.dao;

import by.htp3.hotel.bean.Order;
import by.htp3.hotel.bean.Room;
import by.htp3.hotel.bean.User;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public class RoomDaoImpl extends BaseDaoImpl<Room> implements RoomDao {

	public RoomDaoImpl() {
	}

	@Override
	public List<Room> getFreeRoomsFromDatabase() {

		Session session = getSession();

		List<Long> orders = (List<Long>) session.createQuery("SELECT DISTINCT x.room.id FROM Order x")
				.setCacheable(true)
				.list();

		List<Room> freeRooms;

		if (orders.isEmpty()) {
			freeRooms = (List<Room>) session.createQuery("FROM Room").list();
		} else {
			freeRooms = (List<Room>) session.createQuery("SELECT x FROM Room x WHERE x.id NOT IN :orders")
					.setParameterList("orders", orders)
					.list();
		}

		return freeRooms;
	}

	@Override
	public void addNewRoom(String type, Integer price_a_day, Long roomnumber) {

		Session session = getSession();

		Room room = new Room();
		room.setType(type);
		room.setPrice(price_a_day);
		room.setNumber(roomnumber);

		session.persist(room);
	}

	@Override
	public Query delete(String value, String tableName, String columnName) {

		Session session = getSession();
		Query query = session.createQuery("DELETE FROM " + tableName + " WHERE " + columnName + " = :val");

		Query query1 = query.setParameter("val", value);
		session.close();

		return query1;
	}

	@Override
	public Order reserveRoom(Long xnumber, String login, Date dateIn, Date dateOut) throws DaoException {

		Session session = getSession();

		Order order = new Order();
		order.setDateIn(dateIn);
		order.setDateOut(dateOut);

		List<Room> selectedRoom = (List<Room>) session.createQuery("FROM Room x WHERE x.number = :idRoom")
				.setParameter("idRoom", xnumber)
				.list();

		if (selectedRoom.isEmpty()){
			throw new DaoException("Room " + xnumber + " is not free");
		}

		order.setRoom(selectedRoom.get(0));

		List<User> selectedUser = (List<User>) session.createQuery("FROM User x WHERE x.login = :idUser")
				.setParameter("idUser", login)
				.list();

		if (selectedUser.isEmpty()){
			throw new DaoException("User " + login + " is not exist");
		}

		order.setUser(selectedUser.get(0));

		session.persist(order);

		return order;
	}

	@Override
	public void deleteRoom() {

		Session session = getSession();
		Query query = delete("0", "room", "NUMBER");
		query.executeUpdate();
	}
}

