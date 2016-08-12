package by.htp3.hotel.dao;

import by.htp3.hotel.bean.Room;
import by.htp3.hotel.dao.exception.DAOException;

import java.io.IOException;
import java.util.List;

public interface RoomDAO {

	void delete(String number) throws DAOException;

	List<Room> getFreeRoomsFromDatabase () throws IOException;

	void addNewRoom(String type, String price_a_day, String roomnumber) throws DAOException;
}
