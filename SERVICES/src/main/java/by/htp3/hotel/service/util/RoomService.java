package by.htp3.hotel.service.util;

import by.htp3.hotel.bean.Room;
import by.htp3.hotel.dao.impl.RoomDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.ArrayList;
import java.util.List;

@Service
public class RoomService {

    @Autowired
    private RoomDAO roomDAO;

    @Transactional
    public List<Room> getRoomList() {

        List<Room> freerooms = new ArrayList<>();
        List<Room> rooms = roomDAO.getFreeRoomsFromDatabase(true);

        if (rooms != null) {
            for (Room room : rooms)
                if (room.getUserid() == null) {
                    freerooms.add(room);
                    System.out.println("Rooms:" + room.getNumber()
                            + ", " + room.getPrice() + ", " + room.getType());
                }
        }

        return freerooms;
    }

    @Transactional
    public void reserveRoom(Long xnumber, Long userId) {

        roomDAO.reserveRoom(xnumber, userId);
    }

    @Transactional
    public void deleteRoom(){

        roomDAO.deleteRoom();
    }

    @Transactional
    public List<Room> getFreeRoomsFromDatabase() {
        return roomDAO.getFreeRoomsFromDatabase(true);
    }

    public void addNewRoom(String type, Integer price_a_day, Long roomnumber) {

        roomDAO.addNewRoom(type, price_a_day, roomnumber);
    }

}