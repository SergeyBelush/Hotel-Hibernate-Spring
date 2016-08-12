package by.htp3.hotel.dao.impl;

import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import by.htp3.hotel.bean.Room;
import by.htp3.hotel.dao.RoomDAO;
import by.htp3.hotel.dao.exception.DAOException;
import by.htp3.hotel.dao.impl.pool.ConnectionPool;
import by.htp3.hotel.dao.impl.pool.ConnectionPoolException;

public class SQLRoomDAO implements RoomDAO {

	public List<Room> getFreeRoomsFromDatabase () throws IOException {
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
	public void addNewRoom(String type, String price_a_day, String roomnumber) throws DAOException {
		Connection con = null;
		PreparedStatement st = null;

		try {
			//con = ConnectionPool.getInstance().takeConnection();
			con = DriverManager.getConnection("jdbc:mysql://127.0.0.1/mydb", "root", "12345");

			st = con.prepareStatement("INSERT INTO rooms (typeroom, priceaday, number) VALUES (?,?,?)");

			st.setString(1, type);
			st.setString(2, price_a_day);
			st.setString(3, roomnumber);
			
			st.executeUpdate();

		} catch (SQLException e) {
			throw new DAOException("SQL Error..", e);
		//} catch (ConnectionPoolException e) {
			//throw new DAOException("pool exception", e);
		} finally {

			if (st != null) {
				try {
					st.close();
				} catch (SQLException e) {
				}
			}
//			try {
//				ConnectionPool.getInstance().returnConnection(con);
//			} catch (ConnectionPoolException e) {
//			}

		}
	}

	public void delete(String number) throws DAOException {

		try (
				Connection con = DriverManager.getConnection("jdbc:mysql://127.0.0.1/mydb", "root", "12345");
				PreparedStatement st = con.prepareStatement("DELETE FROM rooms WHERE number =?");
		) {

			st.setString(1, number);
			st.executeUpdate();

		} catch (Exception e) {
			throw new DAOException(e.getMessage());
		}
	}

}
