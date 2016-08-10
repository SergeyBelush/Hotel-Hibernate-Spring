package by.htp3.hotel.service;

import by.htp3.hotel.bean.User;
import by.htp3.hotel.service.exception.ServiceException;

public interface UserService {

	User authorisation(String login, String password) throws ServiceException;
}
