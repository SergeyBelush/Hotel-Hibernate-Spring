package by.htp3.hotel.dao;

import by.htp3.hotel.bean.Order;
import by.htp3.hotel.bean.Room;
import org.hibernate.Query;

import java.util.Date;
import java.util.List;

public interface RoomDao {

    List<Room> getFreeRoomsFromDatabase();

    void addNewRoom(String type, Integer price_a_day, Long roomnumber);

    Query delete(String value, String tableName, String columnName);

    Order reserveRoom(Long xnumber, String login, Date dateIn, Date dateOut) throws DaoException;

    void deleteRoom();
}
