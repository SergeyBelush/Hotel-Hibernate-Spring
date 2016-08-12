package by.htp3.hotel.command.impl;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
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

		List<Room> rooms = DAOFactory.getInstance().getRoomDAO().getFreeRoomsFromDatabase();

		request.setAttribute("free_rooms", rooms);

		request.getRequestDispatcher("showfreerooms.jsp").forward(request, response);

	}
}
