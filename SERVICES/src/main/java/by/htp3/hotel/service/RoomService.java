package by.htp3.hotel.service;

import by.htp3.hotel.bean.Order;
import by.htp3.hotel.bean.Room;
import by.htp3.hotel.dao.DaoException;

import java.util.List;

public interface RoomService {

    Order reserveRoom(Long xnumber, String login, String dateInUser, String dateOutUser) throws UserException, DaoException;

    void deleteRoom();

    List<Room> getFreeRoomsFromDatabase();

    void addNewRoom(String type, Integer price_a_day, Long roomnumber);
}
