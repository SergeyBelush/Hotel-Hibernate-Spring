package by.htp3.hotel.command.impl;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import by.htp3.hotel.command.Command;
import by.htp3.hotel.controller.Controller;
import by.htp3.hotel.dao.DAOFactory;

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

		Integer price_a_day_integer = Integer.valueOf(priceADay);
		Long room_number_long = Long.valueOf(roomnumber);


		try {
			DAOFactory.roomDAO.addNewRoom(type, price_a_day_integer, room_number_long);
			Controller.redirect("Controller?&command=show_free_rooms", request, response);
		} catch (Exception e) {
			send(e.getMessage(), request, response);
			e.printStackTrace();
		}
	}

	private void send(String message, HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setAttribute("errorMessage", message);
		Controller.redirect("showfreerooms.jsp", request, response);
	}

}
