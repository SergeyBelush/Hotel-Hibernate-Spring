package by.htp3.hotel.command.impl;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import by.htp3.hotel.bean.Room;
import by.htp3.hotel.command.Command;
import by.htp3.hotel.command.util.QueryUtil;
import by.htp3.hotel.dao.DAOFactory;

public class GetFreeRooms implements Command {


		
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

		String query = QueryUtil.createHttpQueryString(request);
		request.getSession(true).setAttribute("prev_query", query);

		System.out.println(query);

		List<Room> rooms = DAOFactory.roomDAO.getFreeRoomsFromDatabase();

		request.setAttribute("free_rooms", rooms);

		request.getRequestDispatcher("showfreerooms.jsp").forward(request, response);

	}
}
