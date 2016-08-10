package by.htp3.hotel.dao;

import by.htp3.hotel.bean.User;
import by.htp3.hotel.dao.exception.DAOException;

public interface UserDAO {

	User authorisation(String login, String password) throws DAOException;

	void register(String name, String surname, String login, String pass, String mail) throws DAOException;

	void delete(String login) throws DAOException;
}
