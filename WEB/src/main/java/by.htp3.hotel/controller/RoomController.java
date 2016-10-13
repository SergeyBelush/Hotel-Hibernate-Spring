package by.htp3.hotel.controller;

import by.htp3.hotel.bean.Order;
import by.htp3.hotel.bean.Room;
import by.htp3.hotel.bean.User;
import by.htp3.hotel.dao.DaoException;
import by.htp3.hotel.form.RoomOrder;
import by.htp3.hotel.service.RoomService;
import by.htp3.hotel.service.UserException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class RoomController {

    @Autowired
    protected RoomService roomService;

    @RequestMapping(value = "/freerooms", method = RequestMethod.POST)
    public ModelAndView freerooms() throws Exception  {
        System.out.println("inside freeRoomsssssssssssssss");

        List<Room> freerooms = roomService.getFreeRoomsFromDatabase();

        if (freerooms != null) {
            Map<String, Object> roomMap = new HashMap<>();
            roomMap.put("freerooms", freerooms);
            roomMap.put("selectedRoom", new RoomOrder());
            return new ModelAndView("/room/showfreerooms", roomMap);
        } else {
            return new ModelAndView("/user/user", "errorRoomMessage", "We don't have free rooms!!!");
        }
    }

    @RequestMapping(value = "/reserve", method = RequestMethod.POST)
    public ModelAndView reserve(@ModelAttribute("selectedRoom") RoomOrder roomOrder) throws Exception  {
        System.out.println("inside Reserveeeeeeeeeeee");

        Authentication principal = SecurityContextHolder.getContext()
                .getAuthentication();

        if (principal == null) {
            return new ModelAndView("/index", "user", new User());
        }

        String login = principal.getName();

        System.out.println("Our loginnnnnnnnnnnn " + login);
        Order order;

        try {
            order = roomService.reserveRoom(roomOrder.getNumber(), login,
                    roomOrder.getDateIn(), roomOrder.getDateOut());
        } catch (UserException | DaoException e){
            return new ModelAndView("/room/showfreerooms", "message", e.getMessage());
        }

        return new ModelAndView("/room/reserve", "order", order);
    }


    @RequestMapping(value = {"/freerooms", "/reserve", "/addnewroom", "/addroom"}, method = RequestMethod.GET)
    public ModelAndView checkuser() throws Exception {
        return new ModelAndView("/index", "user", new User());
    }


    @RequestMapping(value = "/addnewroom", method = RequestMethod.POST)
    public ModelAndView addnewroom() throws Exception {

            return new ModelAndView("/room/addnewroom", "addnewroom", new Room());
        }

    @RequestMapping(value = "/addroom", method = RequestMethod.POST)
    public String addnewroom(@ModelAttribute("addnewroom") Room room) throws Exception {

        roomService.addNewRoom(room.getType(), room.getPrice(), room.getNumber());

        return "/room/addroom";
    }
}
