package by.htp3.hotel.dao.impl;

import by.htp3.hotel.bean.Room;
import by.htp3.hotel.dao.RoomDao;
import by.htp3.hotel.dao.RoomDaoImpl;
import junit.framework.TestCase;

import java.util.List;

public class RoomDaoTest extends TestCase {


    public void testRoom() throws Exception {
        RoomDao roomDao = new RoomDaoImpl();
        roomDao.addNewRoom("Test", 500, 0L);
        List<Room> rooms = roomDao.getFreeRoomsFromDatabase();

        Room komnata = null;
        for (Room r : rooms) {
            if (r.getNumber() == 0 && r.getPrice() == 500 && r.getType().equals("Test")) {
                komnata = r;
            }
        }
        assertTrue(komnata != null);
        roomDao.delete("0", "room", "NUMBER");
    }


}
