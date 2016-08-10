package by.htp3.hotel.service.impl;

import by.htp3.hotel.bean.User;
import by.htp3.hotel.dao.DAOFactory;
import by.htp3.hotel.dao.UserDAO;
import by.htp3.hotel.dao.exception.DAOException;
import by.htp3.hotel.service.UserService;
import by.htp3.hotel.service.exception.ServiceAuthException;
import by.htp3.hotel.service.exception.ServiceException;

public class UserServiceImpl implements UserService {

	@Override
	public User authorisation(String login, String password) throws ServiceException, ServiceAuthException{
		if(!Validation.validate(login, password)){
			throw new ServiceAuthException("Wrong parameters!");
		}
		
		DAOFactory daoFactory = DAOFactory.getInstance();
		UserDAO dao = daoFactory.getUserDAO();
		
		User user;
		try {
			user = dao.authorisation(login, password);
			
			if(user == null){
				throw new ServiceAuthException("Wrong login or password!");
			}
			
		} catch (DAOException e) {
			
			throw new ServiceException("Error in source!", e);
			
		}
		
		return user;
	}
	
	
	static class Validation{
		static boolean validate(String login, String password){
			if(login == null || login.isEmpty()){
				return false;
			}
			
			if(password == null || password.isEmpty()){
				return false;
			}
			
			return true;			
		}
	}

}
