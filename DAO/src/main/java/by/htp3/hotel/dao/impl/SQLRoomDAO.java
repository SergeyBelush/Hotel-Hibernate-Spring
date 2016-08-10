package by.htp3.hotel.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import by.htp3.hotel.dao.RoomDAO;
import by.htp3.hotel.dao.exception.DAOException;
import by.htp3.hotel.dao.impl.pool.ConnectionPool;
import by.htp3.hotel.dao.impl.pool.ConnectionPoolException;

public class SQLRoomDAO implements RoomDAO {

	@Override
	public void addNewRoom(String type, String price_a_day, String roomnumber) throws DAOException {
		Connection con = null;
		PreparedStatement st = null;

		try {
			con = ConnectionPool.getInstance().takeConnection();

			st = con.prepareStatement("INSERT INTO rooms (typeroom, priceaday, number) VALUES (?,?,?)");

			st.setString(1, type);
			st.setString(2, price_a_day);
			st.setString(3, roomnumber);
			
			st.executeUpdate();

		} catch (SQLException e) {
			throw new DAOException("SQL Error..", e);
		} catch (ConnectionPoolException e) {
			throw new DAOException("pool exception", e);
		} finally {

			if (st != null) {
				try {
					st.close();
				} catch (SQLException e) {
				}
			}
			try {
				ConnectionPool.getInstance().returnConnection(con);
			} catch (ConnectionPoolException e) {
			}

		}
	}

}
