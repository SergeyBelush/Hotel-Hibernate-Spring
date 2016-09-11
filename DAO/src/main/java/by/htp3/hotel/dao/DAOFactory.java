package by.htp3.hotel.dao;

import by.htp3.hotel.dao.impl.RoomDAO;
import by.htp3.hotel.dao.impl.UserDAO;

public final class DAOFactory {

	public static UserDAO userDAO = new UserDAO();
	public static RoomDAO roomDAO = new RoomDAO();

	private DAOFactory(){

	}
	
}
