package by.htp3.hotel.dao.impl;

import by.htp3.hotel.bean.User;
import by.htp3.hotel.service.util.HibernateUtil;
import by.htp3.hotel.service.util.UserService;

import java.util.List;

public class UserDAO {

	public User authorisation(String login, String password) {

		List<User> users = UserService.getUserList(login, password);

		if(users == null || users.isEmpty()) {
			return null;
		} else {
			System.out.println("User = " +  users);
			return users.get(0);
		}
	}

	public void register(String name, String surname, String login, String pass, String mail) {

		User user = new User();
		user.setName(name);
		user.setSurname(surname);
		user.setLogin(login);
		user.setPass(pass);
		user.setMail(mail);

		HibernateUtil.persistTransaction(user);
	}

	public void delete(String value, String tableName, String columnName)  {

		UserService.deleteUser(value, tableName, columnName);
	}
}

