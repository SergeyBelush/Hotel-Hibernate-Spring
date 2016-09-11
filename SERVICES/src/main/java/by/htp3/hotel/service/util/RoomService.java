package by.htp3.hotel.service.util;

import by.htp3.hotel.bean.Room;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import java.util.List;

public class RoomService {

    public static List<Room> getRoomList(boolean pagination) {

        Session session = HibernateUtil.getSession();
        Query query = session.createQuery("FROM Room");
        List<Room> rooms = query.list();

        for(Room room : rooms) {
            if (room.getUserid() == null)
                rooms.add(room);
                System.out.println("Rooms:" + room.getRoomid() + ", " + room.getNumber() +
                        ", " + room.getPrice() + ", " + room.getType());
        }

        if (pagination) {
            query.setFirstResult(0);
            query.setMaxResults(5);
        }

        query.setCacheable(true);
        return rooms;
    }

    public static void reserveRoom(Long xnumber, Long userId) {
        Session session = HibernateUtil.getSession();
        Transaction transaction = session.beginTransaction();

        List<Room> rooms = getRoomList(false);
        for (Room room : rooms) {
            if (room.getNumber() == xnumber) {
                room.setUserid(userId);
                session.persist(room);
            }
        }
        transaction.commit();
    }

    public static void deleteRoom(String value, String tableName, String columnName){

        Session session = HibernateUtil.getSession();
        Transaction transaction = session.beginTransaction();
        Query query = session.createQuery("DELETE FROM " + tableName + " WHERE " + columnName + " = :val");
        query.setParameter("val", value);

        query.executeUpdate();
        transaction.commit();
    }


    /*    public static void deleteRoom(String numberRoom) {
        HibernateUtil.deleteEntity(numberRoom, "Room", "number");
    }*/

}