package by.htp3.hotel.dao.impl;

import by.htp3.hotel.bean.Room;
import by.htp3.hotel.dao.exception.DAOException;
import junit.framework.TestCase;

import java.io.IOException;
import java.util.List;

/**
 * Created by Сергей on 12.08.2016
 */
public class SQLRoomDAOTest extends TestCase{


    public void testRoom() throws DAOException, IOException {

        SQLRoomDAO roomDAO = new SQLRoomDAO();

        roomDAO.addNewRoom("Test", "500", "0");

        List<Room> rooms = roomDAO.getFreeRoomsFromDatabase();

        Room komnata = null;

        for(Room r : rooms) {
            if (r.getNumber() == 0 && r.getPrice() == 500 && r.getType().equals("Test") ) {
                komnata = r;
            }
        }

       assertTrue(komnata != null);

        roomDAO.delete("0");
    }


}