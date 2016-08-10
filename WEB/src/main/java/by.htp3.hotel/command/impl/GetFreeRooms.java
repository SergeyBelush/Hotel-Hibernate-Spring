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

public class GetFreeRooms implements Command {

	
	public static List<Room> getFreeRoomsFromDatabase () throws IOException {
		List<Room> rooms = new ArrayList<>();
		
		Connection con = null;
		PreparedStatement st = null;
		ResultSet rs = null;
		try {
			con = DriverManager.getConnection("jdbc:mysql://127.0.0.1/mydb", "root", "12345");

			st = con.prepareStatement("SELECT * FROM rooms");
			rs = st.executeQuery();

			while (rs.next()) {
				Room room = new Room(rs.getInt("number"), rs.getString("typeroom"), rs.getInt("priceaday"),
						rs.getInt("userid"));
				if (room.getUserid() == 0) {
					rooms.add(room);
				}
			}

		} catch (SQLException e) {
			throw new IOException(e.getMessage());
		} finally {
			if (rs != null) {
				try {
					rs.close();
				} catch (SQLException e) {
					
				}
			}

			if (st != null) {
				try {
					st.close();
				} catch (SQLException e) {
					
				}
			}
			if (con != null) {
				try {
					con.close();
				} catch (SQLException e) {
					
				}
			}
		}
		return rooms;
	}
		
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

		String query = QueryUtil.createHttpQueryString(request);
		request.getSession(true).setAttribute("prev_query", query);

		System.out.println(query);

		List<Room> rooms = getFreeRoomsFromDatabase();

		request.setAttribute("free_rooms", rooms);

		request.getRequestDispatcher("showfreerooms.jsp").forward(request, response);

	}
}
