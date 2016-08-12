package by.htp3.hotel.command.impl;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import by.htp3.hotel.bean.Room;
import by.htp3.hotel.bean.User;
import by.htp3.hotel.command.Command;
import by.htp3.hotel.controller.Controller;
import by.htp3.hotel.dao.DAOFactory;

public class ReserveRooms implements Command {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

		String internumber = request.getParameter("numbers");


		if (internumber == null || internumber.equals("")) {
			send("Please, Enter Number Room", request, response);
			return;
		}

		int x = Integer.valueOf(internumber);

		List<Room> rooms = DAOFactory.getInstance().getRoomDAO().getFreeRoomsFromDatabase();

		for (Room room : rooms) {
			if (x == room.getNumber()) {

				Connection con = null;
				PreparedStatement st = null;
				ResultSet rs = null;
				User user;
				user = (User) request.getSession(false).getAttribute("user");

				try {
					con = DriverManager.getConnection("jdbc:mysql://127.0.0.1/mydb", "root", "12345");

					st = con.prepareStatement("UPDATE rooms SET userid=? WHERE number=?");
					//st = con.prepareStatement("SELECT * FROM persons where id=?");

					st.setInt(1, user.getUserid());
					System.out.println("bjhbhjj");
					st.setInt(2, x);
					System.out.println("bjhbhjj");

					//System.out.println("bjhbhjj");

					rs = st.executeQuery();

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
			}
		}

		Controller.redirect("reserve.jsp", request, response);
	}

	private void send(String message, HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setAttribute("errorMessage", message);
		Controller.redirect("reserve.jsp", request, response);
	}

}