package by.htp3.hotel.dao.impl;

import by.htp3.hotel.bean.Room;
import junit.framework.TestCase;
import java.util.List;

public class SQLRoomDAOTest extends TestCase{


    public void testRoom() throws Exception {

        RoomDAO roomDAO = new RoomDAO();

        roomDAO.addNewRoom("Test", 500, 0L);

        List<Room> rooms = roomDAO.getFreeRoomsFromDatabase(true);

        Room komnata = null;

        for(Room r : rooms) {
            if (r.getNumber() == 0 && r.getPrice() == 500 && r.getType().equals("Test") ) {
                komnata = r;
            }
        }

       assertTrue(komnata != null);

        roomDAO.delete("0", "room", "NUMBER");
    }


}
