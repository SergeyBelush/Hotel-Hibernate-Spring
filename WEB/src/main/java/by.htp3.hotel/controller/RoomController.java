package by.htp3.hotel.controller;

import by.htp3.hotel.service.util.RoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class RoomController {

    @Autowired
    protected RoomService roomService;

}