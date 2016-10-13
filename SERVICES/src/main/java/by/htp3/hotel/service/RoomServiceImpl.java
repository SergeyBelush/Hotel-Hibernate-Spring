package by.htp3.hotel.service;

import by.htp3.hotel.bean.Order;
import by.htp3.hotel.bean.Room;
import by.htp3.hotel.dao.DaoException;
import by.htp3.hotel.dao.RoomDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Service
@Transactional
public class RoomServiceImpl extends BaseServiceImpl<Room> implements RoomService {

    @Autowired
    private RoomDao roomDao;

    @Override
    public Order reserveRoom(Long xnumber, String login, String dateInUser, String dateOutUser) throws UserException, DaoException {

        if (xnumber == null || xnumber < 0) {
            throw new UserException("Please enter correct room number", null);
        }

        SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy");

        Date dateIn;
        Date dateOut;

        try {
            dateIn = sdf.parse(dateInUser);
            dateOut = sdf.parse(dateOutUser);
        } catch (ParseException e) {
            throw new UserException("Please enter correct date format \"dd.MM.yyyy\"", e);
        }

        return roomDao.reserveRoom(xnumber, login, dateIn, dateOut);
    }

    @Override
    public void deleteRoom(){

        roomDao.deleteRoom();
    }

    @Override
    public List<Room> getFreeRoomsFromDatabase() {

        return roomDao.getFreeRoomsFromDatabase();
    }

    @Override
    public void addNewRoom(String type, Integer price_a_day, Long roomnumber) {

        roomDao.addNewRoom(type, price_a_day, roomnumber);
    }


    public RoomDao getRoomDao() {
        return roomDao;
    }

    public void setRoomDao(RoomDao roomDao) {
        this.roomDao = roomDao;
    }
}