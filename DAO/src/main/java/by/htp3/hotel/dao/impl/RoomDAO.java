package by.htp3.hotel.dao.impl;

import by.htp3.hotel.bean.Room;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class RoomDAO extends BaseDAO<Room> {

	public RoomDAO() {
	}

	public List<Room> getFreeRoomsFromDatabase(boolean pagination) {

		Session session = getSession();

		Query query = session.createQuery("FROM Room");

		if (pagination) {
			query.setFirstResult(0);
			query.setMaxResults(5);
		}

		query.setCacheable(true);

		List<Room> rooms = (List<Room>) query.list();
		session.close();

		return rooms;
	}

	public void addNewRoom(String type, Integer price_a_day, Long roomnumber) {

		Room room = new Room();
		room.setType(type);
		room.setPrice(price_a_day);
		room.setNumber(roomnumber);

		persistTransaction(room);
	}

	public Query delete(String value, String tableName, String columnName) {

		Session session = getSession();
		Query query = session.createQuery("DELETE FROM " + tableName + " WHERE " + columnName + " = :val");

		Query query1 = query.setParameter("val", value);
		session.close();

		return query1;
	}

	public void reserveRoom(Long xnumber, Long userId) {

		Session session = getSession();
		Transaction transaction = session.beginTransaction();

		List<Room> rooms = getRoomList();

		for (Room room : rooms) {
			if (room.getNumber() == xnumber) {
                /*session.merge(room);*/
				room.setUserid(userId);
				session.saveOrUpdate(room);
			}
		}
		transaction.commit();
		session.close();
	}

	public List<Room> getRoomList() {

		List<Room> freerooms = new ArrayList<>();
		List<Room> rooms = getFreeRoomsFromDatabase(true);

		if (rooms != null) {
			for (Room room : rooms)
				if (room.getUserid() == null) {
					freerooms.add(room);
					System.out.println("Rooms:" + room.getNumber() + ", " + room.getPrice() + ", " + room.getType());
				}
		}

		return freerooms;
	}

	public  void deleteRoom() {

		Session session = getSession();
		Transaction transaction = session.beginTransaction();

		Query query = delete("0", "room", "NUMBER");

		query.executeUpdate();
		transaction.commit();
		session.close();
	}
}

