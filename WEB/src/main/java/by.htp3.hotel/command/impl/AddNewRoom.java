package by.htp3.hotel.command.impl;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import by.htp3.hotel.command.Command;
import by.htp3.hotel.controller.Controller;
import by.htp3.hotel.service.RoomService;
import by.htp3.hotel.service.ServiceFactory;
import by.htp3.hotel.service.exception.ServiceException;

public class AddNewRoom implements Command {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

		String type = request.getParameter("type");
		String priceADay = request.getParameter("price_a_day");
		String roomnumber = request.getParameter("room_number");

		if (type == null || type == "") {
			send("Please, Enter Room Type!", request, response);
			return;
		}
		
		if (priceADay == null || priceADay == "") {
			send("Please, Enter Price A Day Room!", request, response);
			return;
		}		
		
		if (roomnumber == null || roomnumber == "") {
			send("Please, Enter Room Number!", request, response);
			return;
		}	
		
		try {
			RoomService roomService = ServiceFactory.getInstance().getRoomService();
			roomService.addNewRoom(type, priceADay, roomnumber);
			Controller.redirect("Controller?&command=show_free_rooms", request, response);
			
		} catch (ServiceException e) {
			send(e.getMessage(), request, response);
			e.printStackTrace();
			//request.getRequestDispatcher("addroom.jsp").forward(request, response);
		}
	}

	private void send(String message, HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setAttribute("errorMessage", message);
		Controller.redirect("showfreerooms.jsp", request, response);
	}

}
