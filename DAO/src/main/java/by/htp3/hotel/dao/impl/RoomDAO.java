package by.htp3.hotel.dao.impl;

import by.htp3.hotel.bean.Room;
import by.htp3.hotel.service.util.HibernateUtil;
import by.htp3.hotel.service.util.RoomService;

import java.util.List;

public class RoomDAO {

	public List<Room> getFreeRoomsFromDatabase () {

		List<Room> rooms = RoomService.getRoomList(true);

		return rooms;
	}

	public void addNewRoom(String type, Integer price_a_day, Long roomnumber)  {

		Room room = new Room();
		room.setType(type);
		room.setPrice(price_a_day);
		room.setNumber(roomnumber);

		HibernateUtil.persistTransaction(room);
	}

	public void delete(String value, String tableName, String columnName) {

		RoomService.deleteRoom(value, tableName, columnName);
	}


	public void reserveRoom(Long xnumber, Long userId) {

		RoomService.reserveRoom(xnumber, userId);
	}


/*	public void delete(String number) {
		RoomService.deleteRoom(number);
	}*/


//ASDFASFDASDFASFASDFASFASDF
}
