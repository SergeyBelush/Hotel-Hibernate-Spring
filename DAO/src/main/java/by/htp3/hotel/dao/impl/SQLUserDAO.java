package by.htp3.hotel.dao.impl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import by.htp3.hotel.bean.User;
import by.htp3.hotel.dao.UserDAO;
import by.htp3.hotel.dao.exception.DAOException;

public class SQLUserDAO implements UserDAO {

	@Override
	public User authorisation(String login, String password) throws DAOException {
		Connection con = null;
		PreparedStatement st = null;
		ResultSet rs = null;
		try {
			con = DriverManager.getConnection("jdbc:mysql://127.0.0.1/mydb", "root", "12345");

			st = con.prepareStatement("SELECT * FROM persons WHERE login=? AND password=?");

			st.setString(1, login);
			st.setString(2, password);

			rs = st.executeQuery();

			if (!rs.next()) {
				return null;
			}

			User user = new User();
			user.setName(rs.getString("name"));
			user.setSurname(rs.getString("surname"));
			user.setUserid(rs.getInt("id"));

			return user;

		} catch (SQLException e) {
			throw new DAOException("Login sql error..", e);
		} finally {
			if (rs != null) {
				try {
					rs.close();
				} catch (SQLException ignored) {

				}
			}

			if (st != null) {
				try {
					st.close();
				} catch (SQLException ignored) {

				}
			}
			if (con != null) {
				try {
					con.close();
				} catch (SQLException ignored) {

				}
			}

		}

	}

	@Override
	public void register(String name, String surname, String login, String pass, String mail) throws DAOException {
		try (
				Connection con = DriverManager.getConnection("jdbc:mysql://127.0.0.1/mydb", "root", "12345");
				PreparedStatement st = con.prepareStatement(
						"INSERT INTO persons (name, surname, login, password, email) VALUES (?, ?, ?, ?, ?)");
		) {
			st.setString(1, name);
			st.setString(2, surname);
			st.setString(3, login);
			st.setString(4, pass);
			st.setString(5, mail);
			st.executeUpdate();

		} catch (Exception e) {
			throw new DAOException(e.getMessage());
		}
	}


	public void delete(String login) throws DAOException {

		try (
				Connection con = DriverManager.getConnection("jdbc:mysql://127.0.0.1/mydb", "root", "12345");
				PreparedStatement st = con.prepareStatement("DELETE FROM persons WHERE login =?");
		) {

			st.setString(1, login);
			st.executeUpdate();

		} catch (Exception e) {
			throw new DAOException(e.getMessage());
		}
	}
}

